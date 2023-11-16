package christmas.domain.entity.discount;

import static christmas.configuration.DateConstant.CHRISTMAS;
import static christmas.configuration.IntegerConstant.MIN_DAY;
import static christmas.configuration.IntegerConstant.ZERO;
import static christmas.message.BenefitMessage.CHRISTMAS_D_DAY_DISCOUNT_MESSAGE;

public class D_DayDiscount {
    private static final int D_DAY_DISCOUNT_INIT_NUMBER = 1000;
    private static final int D_DAY_DISCOUNT_PLUS_NUMBER = 100;
    private final int discount;

    private D_DayDiscount(int date) {
        discount = calcD_DayDiscount(date);
    }

    public static D_DayDiscount create(int date) {
        return new D_DayDiscount(date);
    }

    private int calcD_DayDiscount(int date) {
        if (date <= CHRISTMAS.getValue()) {
            return D_DAY_DISCOUNT_INIT_NUMBER + calcPlusDiscount(date);
        }
        return ZERO.getValue();
    }

    private int calcPlusDiscount(int date) {
        return D_DAY_DISCOUNT_PLUS_NUMBER * (date - MIN_DAY.getValue());
    }

    public String getMessage() {
        return CHRISTMAS_D_DAY_DISCOUNT_MESSAGE.getMessage();
    }

    public int getDiscount() {
        return discount;
    }
}
