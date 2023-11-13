package christmas.domain.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.discount.D_DayDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class D_DayDiscountTest {
    private D_DayDiscount discount;
    @DisplayName("적용 대상 입력에 대한 Discount 계산")
    @Test
    void testDiscount_1() {
        discount = new D_DayDiscount(25);
        assertEquals(discount.getDiscount(), 3400);
    }

    @DisplayName("비적용 대상 입력에 대한 Discount 계산")
    @Test
    void testDiscount_2() {
        discount = new D_DayDiscount(26);
        assertEquals(discount.getDiscount(), 0);
    }
}
