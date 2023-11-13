package christmas.domain.dto;

import christmas.domain.entity.Promotion;
import java.util.List;
import java.util.Map;

public class DtoMapper {
    private DtoMapper() {

    }

    public static OrderPriceDto toOrderPriceDto(int totalPriceBeforeDiscount, int totalBenefit, int expectedPriceAfterDiscount) {
        return new OrderPriceDto(totalPriceBeforeDiscount, totalBenefit, expectedPriceAfterDiscount);
    }

    public static OrdersDto toOrderDto(int visitDate, Map<String, Integer> orders) {
        return new OrdersDto(visitDate, orders);
    }

    public static PromotionDto toPromotionDto(Map<String, Integer> giveaway, Map<String, Integer> promotion, String badge) {
        return new PromotionDto(giveaway, promotion, badge);
    }
}
