package christmas.domain.entity;

public enum EventBadge {
    NULL_BADGE("", 0),
    STAR_BADGE("별", 5000),
    TREE_BADGE("트리", 10000),
    SANTA_BADGE("산타", 20000);

    private final String badgeName;
    private final int condition;
    EventBadge(String badgeName, int condition) {
        this.badgeName = badgeName;
        this.condition = condition;
    }

    public EventBadge getEventBadge(int totalDiscount, EventBadge nowBadge) {
        if(totalDiscount >= condition) {
            return this;
        }
        return nowBadge;
    }

    public String getBadgeName() {
        return badgeName;
    }
}
