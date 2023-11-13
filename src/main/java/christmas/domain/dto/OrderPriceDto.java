package christmas.domain.dto;

public class OrderPriceDto {
    private final int totalPriceBeforeDiscount;
    private final int totalBenefit;
    private final int expectedPriceAfterDiscount;

    public OrderPriceDto(int totalPriceBeforeDiscount, int totalBenefit, int expectedPriceAfterDiscount) {
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
        this.totalBenefit = totalBenefit;
        this.expectedPriceAfterDiscount = expectedPriceAfterDiscount;
    }

    public int getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }

    public int getTotalBenefit() {
        return totalBenefit;
    }

    public int getExpectedPriceAfterDiscount() {
        return expectedPriceAfterDiscount;
    }
}
