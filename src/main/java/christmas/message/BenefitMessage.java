package christmas.message;

public enum BenefitMessage {
    CHRISTMAS_D_DAY_DISCOUNT_MESSAGE("크리스마스 디데이 할인: %s원"),
    WEEKDAY_DISCOUNT_MESSAGE("평일 할인: %s원"),
    WEEKEND_DISCOUNT_MESSAGE("주말 할인: %s원"),
    SPECIAL_DISCOUNT_MESSAGE("특별 할인: %s원"),
    GIVEAWAY_EVENT_MESSAGE("증정 이벤트: %s원");

    private final String message;
    BenefitMessage(String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}
