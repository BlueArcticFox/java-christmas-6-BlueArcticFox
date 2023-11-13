package christmas.configuration;

public enum StringConstant {
    DELIMITER_COMMA(","),
    DELIMITER_DASH("-"),
    APPETIZER("애피타이저"),
    MAIN_DISH("메인"),
    DESSERT("디저트"),
    DRINK("음료");


    private final String value;
    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
