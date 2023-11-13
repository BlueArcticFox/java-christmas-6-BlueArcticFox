package christmas.domain.dto;

import java.util.Map;

public class OrdersDto {
    private final int visitDate;
    private final Map<String, Integer> orders;

    public OrdersDto(int visitDate, Map<String, Integer> orders) {
        this.visitDate = visitDate;
        this.orders = orders;
    }

    public int getVisitDate() {
        return visitDate;
    }

    public Map<String, Integer> getOrders() {
        return orders;
    }
}
