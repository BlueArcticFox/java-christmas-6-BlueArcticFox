package christmas.domain.entity.discount;

import static christmas.message.BenefitMessage.WEEKEND_DISCOUNT_MESSAGE;

public class WeekendDiscount implements WeekDiscount {
    private static final int DISCOUNT_PER_QUANTITY = 2023;
    private final int discount;

    public WeekendDiscount(int mainQuantity) {
        discount = mainQuantity * DISCOUNT_PER_QUANTITY;
    }

    @Override
    public String getMessage() {
        return WEEKEND_DISCOUNT_MESSAGE.getMessage();
    }

    @Override
    public int getDiscount() {
        return discount;
    }
}
