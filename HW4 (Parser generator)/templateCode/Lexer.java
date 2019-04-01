import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    private HashMap<String, String> tokens;
    private InputStream is;
    private Scanner scanner;
    private Integer curPos = 0;
    private MyToken curToken;
    private String inputString;
    private String ignoreExp;

    public Lexer (HashMap<String, String> tokens, InputStream is, String inputString, ignoreExp) {
        this.tokens = tokens;
        this.is = is;
        this.inputString = inputString;
        this.ignoreExp = ignoreExp;
        scanner = new Scanner(this.is);
    }

    private boolean isBlank(int c) {

        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }


    public void nextToken() throws ParseException {

        Matcher wsp = Pattern.compile(ignoreExp).matcher(inputString);

        if (wsp.lookingAt()) {
            String ss = wsp.group();
            inputString = inputString.substring(ss.length());
        }
/*
        if (scanner.hasNext("[\t\r ]+")) {
            scanner.next("[\t\r ]+");
        }
*/
        for (Map.Entry<String, String> entry : tokens.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String regex = value;

            Matcher sp = Pattern.compile(regex).matcher(inputString);

            if (sp.lookingAt()) {
                String newText = sp.group();
                if (newText.length() != 0) {
                    inputString = inputString.substring(newText.length());
                    System.out.println("newText" + newText);
                    curPos += newText.length();
                    curToken = new MyToken(key, newText);
                    return;
                }
            }
/*
            if (scanner.hasNext(regex)) {
                String newText = scanner.next(regex);
                curPos += newText.length();
                curToken = new MyToken(key, newText);
                return;
            }*/
        }

        if (inputString.length() == 0) {
            curToken = new MyToken("eof", "eof");
            return;
        }
        /*
        if (!scanner.hasNext()) {
            curToken = new MyToken("eof", "eof");
            return;
        }*/
        throw new ParseException("No token for input: " + curPos, curPos);
    }

    public MyToken getCurToken() {
        return curToken;
    }
}
