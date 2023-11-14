package christmas.domain.entity;

import christmas.domain.IndexModel;

public class Schedule extends IndexModel {
    private final VisitDate visitDate;
    private final Orders orders;
    private final Promotion promotion;

    private Schedule(VisitDate visitDate, Orders orders, Promotion promotion) {
        this.visitDate = visitDate;
        this.orders = orders;
        this.promotion = promotion;
    }

    public static Schedule create(VisitDate visitDate, Orders orders, Promotion promotion) {
        return new Schedule(visitDate, orders, promotion);
    }

    public VisitDate getVisitDate() {
        return visitDate;
    }

    public Orders getOrders() {
        return orders;
    }

    public Promotion getPromotion() {
        return promotion;
    }
}
