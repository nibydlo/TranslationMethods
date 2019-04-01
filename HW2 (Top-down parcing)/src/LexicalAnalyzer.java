import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class LexicalAnalyzer {

    private InputStream is;
    public int curChar;
    private int curPos;
    private Token curToken;
    public int value;

    public LexicalAnalyzer(InputStream is) throws ParseException {
        this.is = is;
        curPos = 0;
        nextChar();
    }

    private boolean isBlank(int c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    private void nextChar() throws ParseException {
        curPos++;
        try {
            curChar = is.read();
        } catch (IOException e) {
            throw new ParseException(e.getMessage(), curPos);
        }
        while (isBlank(curChar)) {
            nextChar();
        }
    }


    private String cutNumber(int startChar) throws IOException, ParseException {
        StringBuilder res = new StringBuilder(Character.toString((char) curChar));
        nextChar();
        while (Character.isDigit(curChar)) {
            res.append((char) curChar);
            nextChar();
        }
        return new String(res);
    }

    public void nextToken() throws ParseException {
        while (isBlank(curChar)) {
            nextChar();
        }
        switch (curChar) {
            case '(':
                nextChar();
                curToken = Token.LPAREN;
                break;
            case ')':
                nextChar();
                curToken = Token.RPAREN;
                break;
            case '+':
                nextChar();
                curToken = Token.PLUS;
                break;
            case '-':
                nextChar();
                curToken = Token.MINUS;
                break;
            case '*':
                nextChar();
                curToken = Token.MUL;
                break;
            case '^':
                nextChar();
                curToken = Token.POW;
                break;
            case -1:
                curToken = Token.END;
                break;
            default:
                if (Character.isDigit(curChar)) {
                    try {
                        value = Integer.parseInt(cutNumber(curChar));
                    } catch (IOException e) {
                        throw new ParseException("Illegal Character" + (char) curChar, curPos);
                    }
                    curToken = Token.NUMBER;
                } else {
                    throw new ParseException("Illegal Character " + (char) curChar, curPos);
                }
        }
    }


    public Token getCurToken() {
        return curToken;
    }

    public int getCurPos() {
        return curPos;
    }
}
