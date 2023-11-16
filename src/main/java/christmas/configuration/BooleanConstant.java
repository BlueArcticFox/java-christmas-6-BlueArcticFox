package christmas.configuration;

public enum BooleanConstant {
    YES(true),
    NO(false);

    private final boolean value;
    BooleanConstant(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
