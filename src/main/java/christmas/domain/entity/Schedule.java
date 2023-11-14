package christmas.domain.entity;

import christmas.domain.IndexModel;

public class Schedule extends IndexModel {
    private final Orders orders;
    private final Promotion promotion;

    private Schedule( Orders orders, Promotion promotion) {
        this.orders = orders;
        this.promotion = promotion;
    }

    public static Schedule create(Orders orders, Promotion promotion) {
        return new Schedule(orders, promotion);
    }

    public Orders getOrders() {
        return orders;
    }

    public Promotion getPromotion() {
        return promotion;
    }
}
