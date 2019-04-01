import java.io.*;
import java.util.*;

public class TopDownGenerator {


    private HashMap<String, Set<MyToken>> firstSet = new HashMap<>(), followSet = new HashMap<>();
    private HashMap<String, Rule> ruleMap = new HashMap<>();
    private HashMap<String, MyToken> tokenMap = new HashMap<>();
    private HashMap<String, Boolean> couldBeEpsilon = new HashMap<>();
    private HashMap<String, String> tokenStringMap = new HashMap<>();
    private String startNonTerminal;
    private String grammarName;
    private String lexerName;
    private File folder;

    public TopDownGenerator(
            HashMap<String, Set<MyToken>> firstSet,
            HashMap<String, Set<MyToken>> followSet,
            HashMap<String, Rule> ruleMap,
            HashMap<String, MyToken> tokenMap,
            HashMap<String, Boolean> couldBeEpsilon,
            HashMap<String, String> tokenStringMap,
            String startNonTerminal,
            String grammarName
    ) {
        this.firstSet = firstSet;
        this.followSet = followSet;
        this.ruleMap = ruleMap;
        this.tokenMap = tokenMap;
        this.couldBeEpsilon = couldBeEpsilon;
        this.tokenStringMap = tokenStringMap;
        this.startNonTerminal = startNonTerminal;
        this.grammarName = grammarName;
        folder = new File("parser");
        if (!folder.exists()) {
            folder.mkdir();
        }
        this.lexerName = grammarName + "Lexer";
    }

    public void generate(String ignoreExp) throws IOException {

        generateTree();
        generateChildren();
        generateLexer(ignoreExp);
        generateParser();
    }

    private void writeImport(BufferedWriter writer) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/test/import.txt"));
        String s;
        while ((s = reader.readLine()) != null) {

            writer.write(s + "\n");
        }
        reader.close();
    }

    private void generateTree() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("templateCode/Tree.java"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("parser/Tree.java"));

        writeImport(writer);

        String s;
        while ((s = reader.readLine()) != null) {

            writer.write(s + "\n");
        }

        reader.close();
        writer.close();
    }

    private String getUpperedRuleName(String ruleName) {
        return ruleName.substring(0, 1).toUpperCase() + ruleName.substring(1);
    }

    private void generateChildren() throws IOException {


        for (Map.Entry<String, Rule> ruleEntry : ruleMap.entrySet()) {

            String ruleName = ruleEntry.getKey();
            Rule rule = ruleEntry.getValue();

            String upperedRuleName = getUpperedRuleName(ruleName);

            BufferedWriter writer = new BufferedWriter(new FileWriter("parser/" + upperedRuleName + "Tree.java"));
            writeImport(writer);
            writer.write("import java.util.Arrays;\n\n");
            writer.write("public class " + upperedRuleName + "Tree extends Tree {\n\n");
            if (!rule.getReturnValue().equals("")) {
                writer.write("\tpublic " + rule.getReturnValue() + ";\n");
            }
            StringBuilder sbConstructorTitle = new StringBuilder("\tpublic " + upperedRuleName + "Tree(String node, ");
            StringBuilder sbConstructorBody = new StringBuilder("\t\tthis.node = node;\n");
            for (ArrayList<String> arg : rule.getArguments()) {
                writer.write("\tprivate " + arg.get(0) + " " + arg.get(1) + ";\n");
                sbConstructorTitle.append(arg.get(0)).append(" ").append(arg.get(1)).append(", ");
                sbConstructorBody.append("\t\tthis.").append(arg.get(1)).append(" = ").append(arg.get(1)).append(";\n");
            }
            sbConstructorBody.append("\t\tthis.children = Arrays.asList(children);\n");
            sbConstructorTitle.append("Tree... children");
            /*
            if (sbConstructorTitle.charAt(sbConstructorTitle.length() - 1) != '(') { // if it's not empty constructor, delete redundant bracket
                sbConstructorTitle.delete(sbConstructorTitle.length() - 2, sbConstructorTitle.length());
            }*/
            sbConstructorTitle.append(") {\n");
            sbConstructorBody.append("\t}\n");
            writer.write(sbConstructorTitle.toString());
            writer.write(sbConstructorBody.toString());


            writer.write("}\n");
            writer.close();
        }
    }

    private void generateLexer(String ignoreExp) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("templateCode/Lexer.java"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("parser/" + grammarName + "Lexer.java"));

        String s;
        while ((s = reader.readLine()) != null) {
            if (s.equals("public class Lexer {")) {
                s = "public class " + grammarName + "Lexer {";
            }
            if (s.split("\\s+").length > 3 && s.split("\\s+")[1].equals("public") && s.split("\\s+")[2].equals("Lexer")) {
                s = "\tpublic " + grammarName + "Lexer(InputStream is, String inputString) {";
                writer.write(s + "\n");
                writer.write("\t\tHashMap<String, String> tokens = new HashMap();\n");
                for (Map.Entry<String, String> e : tokenStringMap.entrySet()) {
                    writer.write("\t\ttokens.put(\"" + e.getKey() + "\", " + e.getValue() + ");\n");
                }
                writer.write("this.ignoreExp = " + ignoreExp + ";\n");
            } else {
                writer.write(s + "\n");
            }
        }

        reader.close();
        writer.close();
    }

    private String transformArgs(String args, int caseNum) {

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < args.length(); i++) {
            if (args.charAt(i) == '$') {
                if (Character.isDigit(args.charAt(i + 1))) {
                    res.append("t").append(Integer.toString(caseNum)).append("_");
                }
                continue;
            }
            res.append(args.charAt(i));
        }

        return res.toString();
    }

    private String transformCode(String code, int caseNum, int del) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '$') {
                if (Character.isDigit(code.charAt(i + 1))) {
                    res.append("t").append(Integer.toString(caseNum)).append("_");
                } else {
                    res.append("res").append(Integer.toString(caseNum)).append(".");
                }
                continue;
            }
            if (code.charAt(i) == '}') {
                res.append(";\n");
                for (int j = 0; j < del; j++) {
                    res.append('\t');
                }
                continue;
            }
            if (code.charAt(i) == '{') {
                res.append('\n');
                for (int j = 0; j < del; j++) {
                    res.append('\t');
                }
                continue;
            }
            res.append(code.charAt(i));

            if (code.charAt(i) == ';') {
                res.append('\n');
                for (int j = 0; j < del; j++) {
                    res.append('\t');
                }
            }
        }

        return res.toString();
    }

    private void generateParser() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("parser/" + grammarName + "Parser.java"));
        writeImport(writer);
        writer.write("import java.io.InputStream;\n");
        writer.write("import java.text.ParseException;\n\n");
        writer.write("public class " + grammarName + "Parser {\n");
        writer.write("\n\t" + lexerName + " lex;\n");

        // generating function for every non-terminal
        for (Map.Entry<String, Rule> ruleSet : ruleMap.entrySet()) {
            String leftPart = ruleSet.getKey();
            Rule rule = ruleSet.getValue();
            writer.write("\n\t" + getUpperedRuleName(leftPart) + "Tree " + leftPart + "(" + rule.getArgumentsString() + ") throws ParseException {\n");
            int id = 0;
            String q = rule.getArguments().size() == 0 ? "" : ", ";
            if (rule.getOptions().size() == 1) {

                ArrayList<String> parts = new ArrayList<>();
                for (ArrayList<Node> option : rule.getOptions()) {
                    for (int i = 0; i < option.size(); i++) {
                        Node node = option.get(i);
                        if (node instanceof Terminal) {
                            writer.write("\t\tTree t0_" + Integer.toString(id) + " = new Tree(lex.getCurToken().toString());\n");
                            writer.write("\t\t\t\tlex.nextToken();\n");
                            parts.add("t0_" + Integer.toString(id++));
                        } else if (node instanceof NonTerminal) {
                            String rn = ((NonTerminal) node).getRuleName();
                            String args = transformArgs(((NonTerminal) node).getArgumentsString(), 0);
                            writer.write("\t\t" + getUpperedRuleName(rn) + "Tree t0_" + Integer.toString(id) + " = " + node.toString() + "(" + args + ");\n");
                            parts.add("t0_" + Integer.toString(id++));
                        } else if (i != option.size() - 1) {
                            String code = option.get(i).toString();
                            code = transformCode(code, 0, 2);
                            writer.write("\t\t" + code + '\n');
                        }
                    }

                    writer.write("\t\t" + getUpperedRuleName(leftPart) + "Tree res0 = new " + getUpperedRuleName(leftPart) + "Tree(\"" + leftPart + "\", " + rule.getSimpleArguments() + q + String.join(", ", parts.toArray(new String[0])) + ");\n");
                    if (option.get(option.size() - 1) instanceof Code) {
                        String code = option.get(option.size() - 1).toString();
                        code = transformCode(code, 0, 2);
                        writer.write("\t\t\t" + code + '\n');
                    }
                    writer.write("\t\treturn res0;\n");
                }
            } else {
                writer.write("\t\tswitch (lex.getCurToken().getTokenName()) {\n");
                Set<String> alreadyWritten = new HashSet<>();

                int caseNum = 0;

                for (MyToken token : firstSet.get(leftPart)) {

                    int curId = 0;

                    writer.write("\t\t\tcase \"" + token.getTokenName() + "\":\n");
                    alreadyWritten.add(token.getTokenName());
                    ArrayList<String> parts = new ArrayList<>();
                    for (ArrayList<Node> option : rule.getOptions()) {

                        // finding first valueble
                        int valInd = 0;
                        while (option.get(valInd) instanceof Code) {
                            valInd++;
                        }

                        if (option.get(valInd) instanceof Terminal && option.get(valInd).toString().equals(token.getTokenName()) ||
                                option.get(valInd) instanceof NonTerminal && firstSet.get(option.get(valInd).toString()).contains(tokenMap.get(token.getTokenName()))) {

                            for (int i = 0; i < option.size(); i++) {
                                Node node = option.get(i);
                                if (node instanceof Terminal) {
                                    String varName = "t" + Integer.toString(caseNum) + "_" + Integer.toString(curId++);
                                    writer.write("\t\t\t\tTree " + varName + " = new Tree(lex.getCurToken().toString());\n");
                                    writer.write("\t\t\t\tlex.nextToken();\n");
                                    parts.add(varName);
                                } else if (node instanceof NonTerminal) {
                                    String varName = "t" + Integer.toString(caseNum) + "_" + Integer.toString(curId++);
                                    String rn = ((NonTerminal) node).getRuleName();
                                    String args = transformArgs(((NonTerminal) node).getArgumentsString(), caseNum);
                                    writer.write("\t\t\t\t" + getUpperedRuleName(rn) + "Tree " + varName + " = " + node.toString() + "(" + args + ");\n");
                                    parts.add(varName);
                                } else if (i != option.size() - 1) {
                                    String code = option.get(i).toString();
                                    code = transformCode(code, caseNum, 4);
                                    writer.write("\t\t\t\t" + code + '\n');
                                }
                            }

                            String resName = "res" + Integer.toString(caseNum);
                            writer.write("\t\t\t\t" + getUpperedRuleName(leftPart) + "Tree " + resName + " = new " + getUpperedRuleName(leftPart) + "Tree(\"" + leftPart + "\", " + rule.getSimpleArguments() + q + String.join(", ", parts.toArray(new String[0])) + ");\n");
                            if (option.get(option.size() - 1) instanceof Code) {
                                String code = option.get(option.size() - 1).toString();
                                code = transformCode(code, caseNum, 4);
                                writer.write("\t\t\t\t" + code + '\n');
                            }
                            writer.write("\t\t\t\treturn " + resName + ";\n");
                            caseNum++;
                        }
                    }
                }

                if (couldBeEpsilon.get(leftPart)) {
                    for (MyToken token : followSet.get(leftPart)) {
                        if (!alreadyWritten.contains(token.getTokenName())) {
                            writer.write("\t\t\tcase \"" + token.getTokenName() + "\":\n");
                        }
                    }
                    writer.write("\t\t\t\tTree epsTerm = new Tree(\"eps\");\n");

                    writer.write("\t\t\t\treturn new " + getUpperedRuleName(leftPart) + "Tree(\"" + leftPart + "\", " + rule.getSimpleArguments() + q + "epsTerm);\n");
                }

                writer.write("\t\t\tdefault:\n");
                writer.write("\t\t\t\tthrow new AssertionError();\n");

                writer.write("\t\t}\n");
            }
            writer.write("\t}\n");
        }

        // generating parse function
        writer.write("\n\tTree parse(InputStream is, String inputString) throws ParseException {\n");
        writer.write("\t\tlex = new " + lexerName + "(is, inputString);\n");
        writer.write("\t\tlex.nextToken();\n");
        writer.write("\t\tTree ans = " + startNonTerminal + "();\n");
        writer.write("\t\tif (!lex.getCurToken().getTokenName().equals(\"eof\")) {\n");
        writer.write("\t\t\tthrow new AssertionError();\n");
        writer.write("\t\t}\n");
        writer.write("\t\treturn ans;\n");
        writer.write("\t}\n");
        // end of generating parse function
        writer.write("}\n");
        writer.close();
    }
}
