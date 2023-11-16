package christmas.configuration;

public enum DateConstant {
    DECEMBER_FIRST_WEEK_WEIGHT(4),
    SUNDAY(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    WEEKS_NUMBER(7),
    CHRISTMAS(25);

    private final int value;
    DateConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
