package christmas.domain.entity.discount;

import static christmas.configuration.DateConstant.CHRISTMAS;
import static christmas.configuration.DateConstant.SUNDAY;
import static christmas.configuration.IntegerConstant.ZERO;

public class SpecialDiscount {
    private static final int SPECIAL_DISCOUNT = 1000;
    private final int discount;

    public SpecialDiscount(int date, int week) {
        discount = calcSpecialDiscount(date, week);
    }

    private int calcSpecialDiscount(int date, int week) {
        if(isSpecialDiscountDay(date, week)) {
            return SPECIAL_DISCOUNT;
        }
        return ZERO.getValue();
    }

    private boolean isSpecialDiscountDay(int date, int week) {
        return (date == CHRISTMAS.getValue() || week == SUNDAY.getValue());
    }

    public int getDiscount() {
        return discount;
    }
}