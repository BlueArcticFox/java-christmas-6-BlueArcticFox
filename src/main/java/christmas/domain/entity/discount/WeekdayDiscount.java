package christmas.domain.entity.discount;

public class WeekdayDiscount implements WeekDiscount {
    private static final int DISCOUNT_PER_QUANTITY = 2023;
    private final int discount;

    public WeekdayDiscount(int dessertQuantity) {
        discount = dessertQuantity * DISCOUNT_PER_QUANTITY;
    }

    @Override
    public int getDiscount() {
        return discount;
    }
}
