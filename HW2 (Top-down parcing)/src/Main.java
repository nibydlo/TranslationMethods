import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./tmp/test.txt"));
        String testString = "2+2";
        Parser parser = new Parser();

        for (int i = 0; i < 10; i++) {
            testString = ExpressionGenerator.genExpression(i);
            System.out.println(i + " : " + testString);
            Tree tree = parser.parse(new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8)));
            tree.writeGraph("./tmp/graph_" + i + ".dot");
        }

        int i = 10;
        while ((testString = reader.readLine()) != null) {
            System.out.println(i + " : " + testString);
            Tree tree = parser.parse(new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8)));
            tree.writeGraph("./tmp/graph_" + (i++) + ".dot");
        }


    }
}
