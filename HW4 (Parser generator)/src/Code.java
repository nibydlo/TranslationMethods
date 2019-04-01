public class Code implements Node {

    private String code;

    public Code(String code) {
        this.code = code;
    }

    public String getType() {
        return "Code";
    }

    public String getCode() {
        return code;
    }

    public String toString() {
        return getCode();
    }

    public String getAllText() {
        return getCode();
    }
}
