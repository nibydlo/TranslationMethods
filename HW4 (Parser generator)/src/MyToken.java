public class MyToken {

    private String tokenName;
    private String tokenText;

    public MyToken(String tokenName, String tokenText) {
        this.tokenName = tokenName;
        this.tokenText = tokenText;
    }

    public String getTokenName() {
        return this.tokenName;
    }

    public String getTokenText() {
        return this.tokenText;
    }

    public String toString() {
        return this.tokenText;
    }
}
