import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

    private HashMap<String, Set<MyToken>> firstSet = new HashMap<>(), followSet = new HashMap<>();
    private HashMap<String, Rule> ruleMap = new HashMap<>();
    private HashMap<String, MyToken> tokenMap = new HashMap<>();
    private HashMap<String, Boolean> couldBeEpsilon = new HashMap<>();
    private String startNonTerminal;

    private MyToken eofTok = new MyToken("eof", "eof");

    private boolean checkEps(Node n) {
        if (n instanceof Code) {
            return true;
        }
        if (n.getType().equals("Terminal") && tokenMap.get(n.toString()).getTokenText().equals("\"\"")) {
            return true;
        }
        if (n.getType().equals("NonTerminal")) {
            return couldBeEpsilon.get(n.toString());
        }
        return false;
    }

    private void genCouldBeEpsilon() {

        for (String s : ruleMap.keySet()) {
            couldBeEpsilon.put(s, false);
        }

        int changed = 1;
        while (changed != 0) {
            changed = 0;

            for (Map.Entry<String, Rule> rule : ruleMap.entrySet()) {
                if (!couldBeEpsilon.get(rule.getKey())) {
                    for (ArrayList<Node> option : rule.getValue().getOptions()) {
                        boolean onlyEps = true;
                        for (Node e : option) {
                            if ((e instanceof Terminal) && !tokenMap.get(e.toString()).getTokenText().equals("\"\"") || (e instanceof NonTerminal)&& couldBeEpsilon.get(e.toString()).equals(false)) {
                                onlyEps = false;
                                break;
                            }
                        }
                        if (onlyEps) {
                            couldBeEpsilon.put(rule.getKey(), true);
                            changed++;
                            break;
                        }
                    }
                }
            }
        }
    }

    private void genFirst(String leftPart) {

        if (!firstSet.containsKey(leftPart)) {
            firstSet.put(leftPart, new HashSet<>());
        }

        for (ArrayList<Node> option : ruleMap.get(leftPart).getOptions()) {

            for (Node node : option) {
                if (node instanceof Terminal) {
                    if (tokenMap.get(node.toString()).getTokenText().equals("\"\"")) {
                        continue; // cause we interested in following node
                    }
                    firstSet.get(leftPart).add(tokenMap.get(node.toString()));
                    break; // break because we don't interested in following nodes
                } else if (node instanceof NonTerminal) {
                    if (node.toString().equals(leftPart)) {
                        break; // to prevent endless recursion
                    }
                    genFirst(node.toString());
                    firstSet.get(leftPart).addAll(firstSet.get(node.toString()));
                    break; // again because we don't interested in following nodes
                }
            }
        }
    }

    private int addToFollowSet(String key, Set<MyToken> value) {
        int startSize = followSet.get(key).size();
        followSet.get(key).addAll(value);
        return (followSet.get(key).size() - startSize);

    }

    private void genFollow() {

        for (String leftPart : ruleMap.keySet()) {
            followSet.put(leftPart, new HashSet<>());
        }

        int changed = 1;
        while (changed != 0) {

            changed = 0;

            for (Map.Entry<String, Rule> r : ruleMap.entrySet()) {
                String leftPart = r.getKey();
                Rule rule = r.getValue();

                for (ArrayList<Node> option : rule.getOptions()) { // for every option for non-terminal
                    for (int i = 0; i < option.size(); i++) { // for every part in current option
                        if (option.get(i).getType().equals("NonTerminal")) {
                            int j = i + 1;
                            while (j < option.size() && checkEps(option.get(j))) {
                                if (option.get(j).getType().equals("NonTerminal")) {
                                    changed += addToFollowSet(option.get(i).toString(), firstSet.get(option.get(j).toString()));
                                }
                                j++;
                            }
                            if (j == option.size()) { // if it's the last not empty non-terminal in right part of rule
                                changed += addToFollowSet(option.get(i).toString(), followSet.get(leftPart));
                            } else { // regular case, when we first of next non-empty as follow of current part of rule
                                if (option.get(j) instanceof NonTerminal) { // if not terminal
                                    changed += addToFollowSet(option.get(i).toString(), firstSet.get(option.get(j).toString()));
                                } else if (option.get(j) instanceof Terminal) { // if terminal
                                    changed += addToFollowSet(option.get(i).toString(), new HashSet<>(Collections.singletonList(tokenMap.get(option.get(j).toString()))));
                                }
                            }
                        }
                    }
                }
            }
        }

        genFollowEnd(startNonTerminal);
    }

    private void genFollowEnd(String nonTerminal) {

        followSet.get(nonTerminal).add(eofTok);

        for (ArrayList<Node> option : ruleMap.get(nonTerminal).getOptions()) {
            int i = option.size() - 1;
            while (i >= 0 && checkEps(option.get(i))) {
                if (option.get(i).getType().equals("NonTerminal")) {
                    addToFollowSet(option.get(i).toString(), new HashSet<>(Collections.singletonList(eofTok)));
                    if (!followSet.get(option.get(i).toString()).contains(eofTok)) {
                        genFollowEnd(option.get(i).toString());
                    }
                }
                i--;
            }
            if (i >= 0 && (option.get(i) instanceof NonTerminal)) {
                addToFollowSet(option.get(i).toString(), new HashSet<>(Collections.singletonList(eofTok)));
                if (!option.get(i).toString().equals(nonTerminal)) {
                    genFollowEnd(option.get(i).toString());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }

    private void run() throws IOException {
        // parsing
        File initialFile = new File("src/test/arithmeticMemory.txt");
        InputStream stream = new FileInputStream(initialFile);

        CharStream charStream = CharStreams.fromStream(stream);
        GrammarLexer calculatorLexer = new GrammarLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(calculatorLexer);
        GrammarParser calculatorParser = new GrammarParser(tokenStream);
        ParseTree tree = calculatorParser.input();

        String ignoreExp = "";

        if (tree instanceof GrammarParser.ToExprSeqContext) {
            GrammarParser.IgnoreRuleContext irctx = ((GrammarParser.ToExprSeqContext) tree).ignoreRule();
            if (irctx instanceof GrammarParser.AssignIgnoreContext) {
                ignoreExp = ((GrammarParser.AssignIgnoreContext) irctx).REGEX().getText();
            }
        }

        // getting tokens & rules
        GrammarBaseVisitorCustom grammarBaseVisitor = new GrammarBaseVisitorCustom();
        grammarBaseVisitor.visit(tree);
        HashMap<String, String> tokenMapString = grammarBaseVisitor.getTokens();
        // assigning start non-terminal
        startNonTerminal = grammarBaseVisitor.getStartNonTerminal();

        // test output of start non-terminal
        System.out.println("Start non-terminal : " + startNonTerminal);

        // generating map of tokens
        for (Map.Entry<String, String> entry : tokenMapString.entrySet()) {
            tokenMap.put(entry.getKey(), new MyToken(entry.getKey(), entry.getValue()));
        }

        // test output of map of tokens
        System.out.println("\n\n================== TOKENS ==================\n");
        for (Map.Entry<String, MyToken> entry : tokenMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // generating map of rules
        ruleMap = grammarBaseVisitor.getRules();

        // test output of map of rules
        System.out.println("\n\n================== RULES ==================\n");
        for (Map.Entry<String, Rule> ruleEntry : ruleMap.entrySet()) {
            System.out.print("leftPart : " + ruleEntry.getKey());
            System.out.println(" rule : " + ruleEntry.getValue());
        }

        // gen could be epsilon
        genCouldBeEpsilon();
        System.out.println("\n\nWhat non-terminal could be epsilon: " + couldBeEpsilon);

        // building first
        for (String leftPart : ruleMap.keySet()) {
            if (!firstSet.containsKey(leftPart)) {
                genFirst(leftPart);
            }
        }

        // test output of first
        System.out.println("\n\n================== FIRST SET ==================\n");
        for (Map.Entry<String, Set<MyToken>> e : firstSet.entrySet()) {
            System.out.println("non-terminal : " + e.getKey() + "    firstSet : " + e.getValue());
        }

        // building follow
        genFollow();

        // test output of follow
        System.out.println("\n\n================== FOLLOW SET ==================\n");
        for (Map.Entry<String, Set<MyToken>> e : followSet.entrySet()) {
            System.out.println("non-terminal : " + e.getKey() + "    followSet : " + e.getValue());
        }

        // start of generating top-down parcer
        TopDownGenerator tdg = new TopDownGenerator(firstSet, followSet, ruleMap, tokenMap, couldBeEpsilon, tokenMapString, startNonTerminal, "ArithmeticMemory");

        System.out.println("\n\n================== GENERATE TREE CLASS ==================\n");
        tdg.generate(ignoreExp);
    }
}
