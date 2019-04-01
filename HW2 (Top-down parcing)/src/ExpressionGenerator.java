import java.util.Random;

public class ExpressionGenerator {

    public static String genExpression(int h) {

        Random rnd = new Random();
        if (h == 0) {
            return Integer.toString(rnd.nextInt(10000));
        }
        switch (rnd.nextInt(5)) {
            // number
            case 0:
                return Integer.toString(rnd.nextInt(10000));
            // expression in brackets
            case 1:
                return "(" + genExpression(h - 1) + ")";
            // expression with binary operator
            case 2:
                String binOp;
                switch (rnd.nextInt(3)) {
                    case 0:
                        binOp = "+";
                        break;
                    case 1:
                        binOp = "-";
                        break;
                    default:
                        binOp = "*";
                        break;
                }
                return genExpression(h - 1) + binOp + genExpression(h - 1);
            // number with unary minus
            case 3:
                return "-" + Integer.toString(rnd.nextInt(10000));
            // expression with unary minus
            default:
                return "-(" + genExpression(h - 1) + ")";
        }
    }
}
