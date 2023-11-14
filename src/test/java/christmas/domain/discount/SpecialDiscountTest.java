package christmas.domain.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.VisitDate;
import christmas.domain.entity.discount.SpecialDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialDiscountTest {
    private VisitDate date;
    private SpecialDiscount discount;
    @DisplayName("일요일에서의 discount 반환")
    @Test
    void testSpecialDiscount_1(){
        date = VisitDate.create(24);
        discount = SpecialDiscount.create(date.getDate(), date.getWeek());
        assertEquals(discount.getDiscount(), 1000);
    }

    @DisplayName("크리스마스에서의 discount 반환")
    @Test
    void testSpecialDiscount_2(){
        date = VisitDate.create(25);
        discount = SpecialDiscount.create(date.getDate(), date.getWeek());
        assertEquals(discount.getDiscount(), 1000);
    }

    @DisplayName("이벤트 날짜가 아닌 날의 discount 반환")
    @Test
    void testSpecialDiscount_3(){
        date = VisitDate.create(23);
        discount = SpecialDiscount.create(date.getDate(), date.getWeek());
        assertEquals(discount.getDiscount(), 0);
    }
}
