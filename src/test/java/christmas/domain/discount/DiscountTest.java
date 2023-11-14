package christmas.domain.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.Orders;
import christmas.domain.entity.VisitDate;
import christmas.domain.entity.discount.MyDiscount;
import christmas.service.OrdersService;
import christmas.service.OrdersServiceImpl;
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
        ordersService = new OrdersServiceImpl();
        visitDate = VisitDate.create(24);
        orders = ordersService.generateOrders(List.of(
                "타파스-3",
                "티본스테이크-2",
                "아이스크림-4"
        ));
        discount = MyDiscount.create(visitDate, orders);
    }

    @DisplayName("D_Day 할인 테스트")
    @Test
    void discountTest_1() {
        assertEquals(discount.getD_DayDiscount().getDiscount(), 3300);
    }

    @DisplayName("스페셜 할인 테스트")
    @Test
    void discountTest_2() {
        assertEquals(discount.getSpecialDiscount().getDiscount(), 1000);
    }

    @DisplayName("Weekday 할인 테스트")
    @Test
    void discountTest_3() {
        assertEquals(discount.getWeekDiscount().getDiscount(), 8092);
    }

    @DisplayName("Weekend 할인 테스트")
    @Test
    void discountTest_4() {
        visitDate = VisitDate.create(23);
        discount = MyDiscount.create(visitDate, orders);
        assertEquals(discount.getWeekDiscount().getDiscount(), 4046);
    }

    @DisplayName("전체 할인 금액 테스트")
    @Test
    void discountTest_5() {
        assertEquals(discount.getAllDiscount(), 12392);
    }
}
