package christmas.domain.dto;

public class OrderPriceDto {
    private final int totalPriceBeforeDiscount;
    private final int totalBenefit;
    private final int expectedPriceAfterDiscount;

    private OrderPriceDto(int totalPriceBeforeDiscount, int totalBenefit, int expectedPriceAfterDiscount) {
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
        this.totalBenefit = totalBenefit;
        this.expectedPriceAfterDiscount = expectedPriceAfterDiscount;
    }

    protected static OrderPriceDto create(int totalPriceBeforeDiscount, int totalBenefit, int expectedPriceAfterDiscount) {
        return new OrderPriceDto(totalPriceBeforeDiscount,totalBenefit,expectedPriceAfterDiscount);
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
