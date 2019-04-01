
import org.antlr.v4.runtime.misc.Array2DHashSet;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class GrammarBaseVisitorCustom extends GrammarBaseVisitor {

    private String startNonTerminal = "";
    private HashMap<String, String> tokens = new HashMap<>();
    private HashMap<String, Set<String>> rulesString = new HashMap<>();
    private HashMap<String, Rule> rules = new HashMap<>();


    public HashMap<String, String> getTokens() {
        return tokens;
    }

    public HashMap<String, Rule> getRules() {
        return rules;
    }

    public String getStartNonTerminal() {
        return startNonTerminal;
    }

    @Override
    public Object visitAssignToken(GrammarParser.AssignTokenContext ctx) {
        String tokenName = ctx.TOKENNAME().getText();
        String tokenRegex = ctx.REGEX().getText();
        tokens.put(tokenName, tokenRegex);
        return visitChildren(ctx);
    }

    @Override
    public Object visitAssignRule(GrammarParser.AssignRuleContext ctx) {
        String ruleStart = ctx.RULENAME().getText();
        if (startNonTerminal.equals("")) {
            startNonTerminal = ruleStart;
        }
        String retValue = "";
        ArrayList<ArrayList<String>> argumentsList = new ArrayList<>();
        if (ctx.arguments() != null) {
            GrammarParser.ArgumentsContext ac = ctx.arguments();
            if (ac instanceof GrammarParser.ToInitVarContext) {
                for (GrammarParser.InitVarContext ivc : ((GrammarParser.ToInitVarContext) ac).initVar()) {
                    if (ivc instanceof GrammarParser.InitializeVarContext) {
                        ArrayList<String> tempList = new ArrayList<>();
                        tempList.add(((GrammarParser.InitializeVarContext) ivc).VARTYPE().getText());
                        tempList.add(((GrammarParser.InitializeVarContext) ivc).VARNAME().getText().substring(1));
                        argumentsList.add(tempList);
                    }
                }
            }
        }

        if (ctx.CODE() != null) {
            retValue = ctx.CODE().getText();
            retValue = retValue.substring(1, retValue.length() - 1);
        }

        Set<ArrayList<Node>> setOfRightParts = new HashSet<>();
        for (GrammarParser.OptionContext oc : ctx.option()) {

            if (oc instanceof GrammarParser.InOptionContext) {
                ArrayList<Node> thisRightPart =  new ArrayList<>();
                for (GrammarParser.RightPartElemContext rpec : ((GrammarParser.InOptionContext) oc).rightPartElem()) {

                    if (rpec instanceof GrammarParser.ToPassArgumentsContext) {
                        String nonTermName = ((GrammarParser.ToPassArgumentsContext) rpec).RULENAME().getText();
                        ArrayList<String> nonTermArgs = new ArrayList<>();
                        GrammarParser.PassArgumentsContext pac = ((GrammarParser.ToPassArgumentsContext) rpec).passArguments();
                        if (pac instanceof GrammarParser.PassingVariablesContext) {
                            for (GrammarParser.ArgumentContext tn : ((GrammarParser.PassingVariablesContext) pac).argument()) {
                                nonTermArgs.add(tn.getText());
                            }
                        }
                        thisRightPart.add(new NonTerminal(nonTermName, nonTermArgs));
                    }

                    if (rpec instanceof GrammarParser.RightPartElemTokenContext) {
                        thisRightPart.add(new Terminal(rpec.getText()));
                    }

                    if (rpec instanceof GrammarParser.RightPartElemCodeContext) {
                        thisRightPart.add(new Code(rpec.getText()));
                    }
                }
                setOfRightParts.add(thisRightPart);
            }
        }
        rules.put(ruleStart, new Rule(ruleStart, argumentsList, retValue, setOfRightParts));

        return visitChildren(ctx);
    }

}
