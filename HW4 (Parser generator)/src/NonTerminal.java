import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonTerminal implements Node {

    private String ruleName;
    private List<String> arguments = new ArrayList<>();

    public NonTerminal(String ruleName) {

        this.ruleName = ruleName;
        this.arguments = new ArrayList<>();
    }

    public NonTerminal(String ruleName, ArrayList<String> arguments) {
        this.ruleName = ruleName;
        this.arguments = arguments;

    }

    public String getType() {
        return "NonTerminal";
    }

    public String getRuleName() {
        return ruleName;
    }

    public ArrayList<String> getArguments() {
        return new ArrayList<>(arguments);
    }

    public String getArgumentsString() {
        return String.join(", ", arguments);
    }

    public String toString() {
        return getRuleName();
    }
}
