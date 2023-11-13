package christmas.domain.entity.discount;

public class WeekendDiscount implements WeekDiscount {
    private static final int DISCOUNT_PER_QUANTITY = 2023;
    private final int discount;

    public WeekendDiscount(int mainQuantity) {
        discount = mainQuantity * DISCOUNT_PER_QUANTITY;
    }

    @Override
    public int getDiscount() {
        return discount;
    }
}
