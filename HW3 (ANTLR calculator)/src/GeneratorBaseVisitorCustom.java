import java.util.HashMap;

public class GeneratorBaseVisitorCustom extends GeneratorBaseVisitor {

    private HashMap<String, String> tokens = new HashMap<>();
//    private HashMap<String, String> rules = new HashMap<>();

    public HashMap<String, String> getTokens() {
        return tokens;
    }
/*
    public HashMap<String, String> getRules() {
        return rules;
    }
*/
    @Override
    public Object visitAssignToken(GeneratorParser.AssignTokenContext ctx) {
        String tokenName = ctx.TOKENNAME().getText();
        String tokenRegex = ctx.REGEX().getText();
        tokens.put(tokenName, tokenRegex);
        return visitChildren(ctx);
    }
/*
    @Override
    public Object visitAssignRule(GeneratorParser.AssignRuleContext ctx) {
        String leftPart = ctx.RULENAME().getText();
        String rightPart = ctx.rightPart().getText();
        rules.put(leftPart, rightPart);
        return visitChildren(ctx);
    }
*/
}
