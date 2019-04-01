public class Terminal implements Node {

    private String tokenName;

    public Terminal(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getType() {
        return "Terminal";
    }

    public String getTokenName() {
        return tokenName;
    }

    public String toString() {
        return getTokenName();
    }
}
