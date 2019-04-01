import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.Scanner;

public class TestArithmetic {

    private static String readFile (String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static void simpleVis(Tree tree, int indent) {
        System.out.println();
        for (int i = 0; i < indent; i++) {
            System.out.print('\t');
        }
        System.out.print(tree.node);
        for (int i = 0; i < tree.children.size(); i++) {
            simpleVis(tree.children.get(i), indent + 1);
        }
    }

    public static void main(String[] args) throws ParseException, IOException {
        ArithmeticMemoryParser parser = new ArithmeticMemoryParser();
        //String testString = "2 + ( 32  - ( 3 + 7 )  * 3 ) + 5 ";
         //String testString = "5 - 1 - 1 ";
        //String testString = "2 ^ 2 ^ 2 ";
         //Tree tree = parser.parse(new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8)));

        String file = readFile("artestSimple.txt");

        Tree tree = parser.parse(new FileInputStream("artestSimple.txt"), file);
        simpleVis(tree, 0);
        System.out.println();
        if (tree instanceof StartTree) {
            System.out.println("hm is " + ((StartTree) tree).hm);
        }
        if (tree instanceof ExpTree) {
            System.out.println("Value is " + ((ExpTree) tree).val);
        }
        //String content = readFile("test.txt", StandardCharsets.UTF_8);
    }

}
