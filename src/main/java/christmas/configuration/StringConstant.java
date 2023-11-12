package christmas.configuration;

public enum StringConstant {
    DELIMITER_COMMA(","),
    DELIMITER_DASH("-");

    private final String value;
    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
