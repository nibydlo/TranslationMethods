import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Rule {

    private String leftPart;
    private ArrayList<ArrayList<String>> arguments;
    private String returns;
    private Set<ArrayList<Node>> options;
    //private ArrayList<Node> rightPart;

    public Rule(String leftPart, ArrayList<ArrayList<String>> arguments, String returns, Set<ArrayList<Node>> options) {
        this.leftPart = leftPart;
        this.arguments = arguments;
        this.returns = returns;
        this.options = options;
    }

    public String getRuleName() {
        return leftPart;
    }

    /*
    public ArrayList<Node> getRightPart() {
        return rightPart;
    }*/

    public Set<ArrayList<Node>> getOptions() {
        return options;
    }

    public ArrayList<ArrayList<String>> getArguments() {
        return arguments;
    }

    public String getArgumentsString() {

        List<String> tempList = new ArrayList<>();
        for (ArrayList<String> a : arguments) {
            tempList.add(a.get(0) + " " + a.get(1));
        }
        return String.join(", ", tempList);
    }

    public String getSimpleArguments() {
        List<String> tempList = new ArrayList<>();
        for (ArrayList<String> a : arguments) {
            tempList.add(a.get(1));
        }
        return String.join(", ", tempList);
    }

    public String getReturnValue() {
        return returns;
    }

    public String toString() {
        return "<" + leftPart + " : " + arguments + " : " + returns + " : " + optionsString() + ">";
    }

    private String optionsString() {
        StringBuilder sb = new StringBuilder("{");
        for (ArrayList<Node> option : options) {
            sb.append("(");
            for (Node n : option) {
                sb.append(n.toString() + " ");
            }
            sb.append(")");
        }
        sb.append("}");

        return sb.toString();
    }

}
