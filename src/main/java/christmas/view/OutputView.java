package christmas.view;

import christmas.domain.dto.OrderPriceDto;
import christmas.domain.dto.OrdersDto;
import christmas.domain.dto.PromotionDto;

public interface OutputView {
    void printWelcome();
    void printPromotionPreview(OrdersDto ordersDto);
    void printOrders(OrdersDto ordersDto);
    void printTotalPriceBeforeDiscount(OrderPriceDto orderPriceDto);
    void printGiveaway(PromotionDto promotionDto);
    void printBenefit(PromotionDto promotionDto);
    void printTotalBenefit(OrderPriceDto orderPriceDto);
    void printExpectedPriceAfterDiscount(OrderPriceDto orderPriceDto);
    void printEventBadge(PromotionDto promotionDto);
}
