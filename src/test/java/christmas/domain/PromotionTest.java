package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.Orders;
import christmas.domain.entity.Promotion;
import christmas.domain.entity.VisitDate;
import christmas.service.OrdersService;
import christmas.service.OrdersServiceImpl;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PromotionTest {
    private OrdersService ordersService;
    private Orders orders;
    private VisitDate visitDate;
    private Promotion promotion;
    @BeforeEach
    void setup() {
        ordersService = new OrdersServiceImpl();
        visitDate = VisitDate.create(24);
        orders = ordersService.generateOrders(List.of(
                "타파스-3",
                "티본스테이크-2",
                "아이스크림-4"
        ));
        promotion = Promotion.create(visitDate, orders);
    }

    @DisplayName("전체 혜택 금액 테스트")
    @Test
    void promotionTest_1() {
       assertEquals(promotion.getTotalBenefit(), 12392+25000);
    }
}
