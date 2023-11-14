package christmas.domain.entity.discount;

import static christmas.configuration.DateConstant.CHRISTMAS;
import static christmas.configuration.DateConstant.SUNDAY;
import static christmas.configuration.IntegerConstant.ZERO;
import static christmas.message.BenefitMessage.SPECIAL_DISCOUNT_MESSAGE;

public class SpecialDiscount {
    private static final int SPECIAL_DISCOUNT = 1000;
    private final int discount;

    private SpecialDiscount(int date, int week) {
        discount = calcSpecialDiscount(date, week);
    }

    public static SpecialDiscount create(int date, int week) {
        return new SpecialDiscount(date, week);
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

    public String getMessage() {
        return SPECIAL_DISCOUNT_MESSAGE.getMessage();
    }

    public int getDiscount() {
        return discount;
    }
}
