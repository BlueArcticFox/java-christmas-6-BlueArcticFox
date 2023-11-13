package christmas.message;

public enum BenefitMessage {
    CHRISTMAS_D_DAY_DISCOUNT_NAME("크리스마스 디데이 할인: %d원"),
    WEEKDAY_DISCOUNT_NAME("평일 할인: %d원"),
    WEEKEND_DISCOUNT_NAME("주말 할인: %d원"),
    SPECIAL_DISCOUNT_NAME("특별 할인: %d원"),
    GIVEAWAY_EVENT_NAME("증정 이벤트: %d원");

    private final String message;
    BenefitMessage(String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}
