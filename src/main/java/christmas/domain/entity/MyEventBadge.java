package christmas.domain.entity;

public class MyEventBadge {
    private final EventBadge badge;

    private MyEventBadge(int totalDiscount) {
        badge = decideEventBadge(totalDiscount);
    }

    public static MyEventBadge create(int totalDiscount) {
        return new MyEventBadge(totalDiscount);
    }

    private EventBadge decideEventBadge(int totalDiscount) {
        EventBadge result = EventBadge.NULL_BADGE;
        for(EventBadge condition : EventBadge.values()) {
            result = condition.getEventBadge(totalDiscount, result);
        }
        return result;
    }

    public EventBadge getBadge() {
        return badge;
    }
}
