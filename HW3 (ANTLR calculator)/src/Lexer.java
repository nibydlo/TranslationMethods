import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lexer {

    private HashMap<String, String> tokens;
    private InputStream is;
    private Scanner scanner;
    private Integer curPos = 0;

    public Lexer(HashMap<String, String> tokens, InputStream is) {
        this.tokens = tokens;
        this.is = is;
        scanner = new Scanner(this.is);
    }

    private boolean isBlank(int c) {

        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }



    public Token nextToken() throws ParseException {

        if (scanner.hasNext("[\t\r ]+")) {
            scanner.next("[\t\r ]+");
        }

        for(Map.Entry<String, String> entry : tokens.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String regex = value.substring(1, value.length() - 1);
            System.out.println(regex + scanner.hasNext(regex));
            if (scanner.hasNext(regex)) {
                String newText = scanner.next(regex);
                curPos += newText.length();
                return new Token(key, newText);
            }
        }
        throw new ParseException("No token for input: " + curPos, curPos);
    }
}
