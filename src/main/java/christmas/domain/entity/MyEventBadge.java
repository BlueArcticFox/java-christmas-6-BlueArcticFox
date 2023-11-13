package christmas.domain.entity;

public class MyEventBadge {
    private final EventBadge badge;

    public MyEventBadge(int totalDiscount) {
        badge = decideEventBadge(totalDiscount);
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
