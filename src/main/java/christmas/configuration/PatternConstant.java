package christmas.configuration;

public enum PatternConstant {
    REGEX("[가-힣]+-\\d+(?:,\\s*[가-힣]+-\\d+)*\\s*$"),
    THOUSAND_SEPARATOR("###,##0");

    private final String value;
    PatternConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
