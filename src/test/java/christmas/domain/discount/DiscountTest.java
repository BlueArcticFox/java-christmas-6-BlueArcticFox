package christmas.domain.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.Orders;
import christmas.domain.entity.VisitDate;
import christmas.domain.entity.discount.MyDiscount;
import christmas.service.OrdersService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountTest {
    private OrdersService ordersService;
    private Orders orders;
    private VisitDate visitDate;
    private MyDiscount discount;
    @BeforeEach
    void setup() {
        ordersService = new OrdersService();
        visitDate = new VisitDate(24);
        orders = ordersService.generateOrders(List.of(
                "타파스-3",
                "티본스테이크-2",
                "아이스크림-4"
        ));
        discount = new MyDiscount(visitDate, orders);
    }

    @DisplayName("D_Day 할인 테스트")
    @Test
    void discountTest_1() {
        assertEquals(discount.getD_DayDiscount(), 3300);
    }

    @DisplayName("스페셜 할인 테스트")
    @Test
    void discountTest_2() {
        assertEquals(discount.getSpecialDiscount(), 1000);
    }

    @DisplayName("Weekday 할인 테스트")
    @Test
    void discountTest_3() {
        assertEquals(discount.getWeekDiscount(), 8092);
    }

    @DisplayName("Weekend 할인 테스트")
    @Test
    void discountTest_4() {
        visitDate = new VisitDate(23);
        discount = new MyDiscount(visitDate, orders);
        assertEquals(discount.getWeekDiscount(), 4046);
    }

    @DisplayName("전체 할인 금액 테스트")
    @Test
    void discountTest_5() {
        assertEquals(discount.getAllDiscount(), 12392);
    }
}
