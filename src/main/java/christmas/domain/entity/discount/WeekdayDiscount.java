package christmas.domain.entity.discount;

import static christmas.message.BenefitMessage.WEEKDAY_DISCOUNT_MESSAGE;

public class WeekdayDiscount implements WeekDiscount {
    private static final int DISCOUNT_PER_QUANTITY = 2023;
    private final int discount;

    private WeekdayDiscount(int dessertQuantity) {
        discount = dessertQuantity * DISCOUNT_PER_QUANTITY;
    }

    public static WeekdayDiscount create(int dessertQuantity) {
        return new WeekdayDiscount(dessertQuantity);
    }

    @Override
    public String getMessage() {
        return WEEKDAY_DISCOUNT_MESSAGE.getMessage();
    }

    @Override
    public int getDiscount() {
        return discount;
    }
}
