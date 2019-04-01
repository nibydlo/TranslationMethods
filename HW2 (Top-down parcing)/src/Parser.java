import java.io.InputStream;
import java.text.ParseException;

public class Parser {

    LexicalAnalyzer lex;

    Tree APrime() throws ParseException {
        switch (lex.getCurToken()) {
            case RPAREN:
            case MINUS:
            case MUL:
            case PLUS:
            case END:
                Tree eTerminal = new Tree("e");
                return new Tree("A'", eTerminal);
            case POW:
                lex.nextToken();
                if (lex.getCurToken() != Token.NUMBER) {
                    throw new ParseException("number expected after pow sign at position " + lex.getCurPos(),lex.getCurPos());
                }
                Tree powTerminal = new Tree("^");
                Tree cont = F();
                return new Tree("A'", powTerminal, cont);
            default:
                throw new AssertionError();
        }
    }

    Tree F() throws ParseException {
        switch (lex.getCurToken()) {
            case NUMBER:
                lex.nextToken();
                Tree numberTerminal = new Tree(Integer.toString(lex.value));
                Tree cont = APrime();
                return new Tree("F", numberTerminal, cont);
            case MINUS:
                lex.nextToken();
                Tree cont3 = F();
                Tree unaryMinusTerminal = new Tree("-");
                return new Tree("F", unaryMinusTerminal, cont3);
            case LPAREN:
                lex.nextToken();
                Tree cont2 = E();
                if (lex.getCurToken() != Token.RPAREN) {
                    throw new ParseException(") expected  at position " + lex.getCurPos(), lex.getCurPos());
                }
                lex.nextToken();
                Tree lparenTerminal = new Tree("(");
                Tree rparenTerminal = new Tree(")");
                return new Tree("F", lparenTerminal, cont2, rparenTerminal);
            default:
                throw new AssertionError();
        }
    }

    Tree T() throws ParseException {
        Tree sub = F();
        Tree cont = TPrime();
        return new Tree("T", sub, cont);
    }

    Tree TPrime() throws ParseException {
        switch (lex.getCurToken()) {
            case MUL:
                lex.nextToken();
                Tree sub = F();
                Tree cont = TPrime();
                Tree operTerminal = new Tree("*");
                return new Tree("T'", operTerminal, sub, cont);
            case PLUS:
            case MINUS:
            case RPAREN:
            case END:
                Tree epsilonTerminal = new Tree("e");
                return new Tree("T'", epsilonTerminal);
            default:
                throw new AssertionError();
        }
    }

    Tree E() throws ParseException {
        Tree sub = T();
        Tree cont = EPrime();
        return new Tree("E", sub, cont);
    }

    Tree EPrime() throws ParseException {
        Tree operTerminal = null;
        switch (lex.getCurToken()) {
            case MINUS:
                operTerminal = new Tree("-");
            case PLUS:
                lex.nextToken();
                Tree sub = T();
                Tree cont = EPrime();
                if (operTerminal == null) {
                    operTerminal = new Tree("+");
                }
                return new Tree("E'", operTerminal, sub, cont);
            case RPAREN:
            case END:
                Tree epsilonterminal = new Tree("e");
                return new Tree("E'", epsilonterminal);
            default:
                throw new AssertionError();
        }
    }

    Tree parse(InputStream is) throws ParseException {
        lex = new LexicalAnalyzer(is);
        lex.nextToken();
        Tree ans = E();
        if (lex.getCurToken() != Token.END) {
            throw new AssertionError();
        }
        return ans;
    }
}
