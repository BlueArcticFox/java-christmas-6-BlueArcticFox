package christmas.configuration;

public enum IntegerConstant {
    ZERO(0),
    MAX_QUANTITY(20),
    MIN_DAY(1),
    MAX_DAY(31);

    private final int value;
    IntegerConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
