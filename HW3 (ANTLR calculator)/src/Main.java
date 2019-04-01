import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        File initialFile = new File("grammar.txt");
        InputStream stream = new FileInputStream(initialFile);

        CharStream charStream = CharStreams.fromStream(stream);
        GeneratorLexer calculatorLexer = new GeneratorLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(calculatorLexer);
        GeneratorParser calculatorParser = new GeneratorParser(tokenStream);
        ParseTree tree = calculatorParser.ruleSeq();

        GeneratorBaseVisitorCustom generatorBaseVisitor = new GeneratorBaseVisitorCustom();
        generatorBaseVisitor.visit(tree);
        HashMap<String, String> m = generatorBaseVisitor.getTokens();
        System.out.println(m);
        /*HashMap<String, String> rules = generatorBaseVisitor.getRules();
        System.out.println(rules);
*/
        Lexer lexer = new Lexer(m, new FileInputStream("sample.txt"));
        Token token = lexer.nextToken();
        System.out.println(token);
        token = lexer.nextToken();
        System.out.println(token);
        token = lexer.nextToken();
        System.out.println(token);
    }
}
