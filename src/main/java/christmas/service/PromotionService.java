package christmas.service;

import christmas.domain.dto.OrderPriceDto;
import christmas.domain.dto.PromotionDto;
import christmas.domain.entity.Orders;
import christmas.domain.entity.Promotion;
import christmas.domain.entity.VisitDate;

public interface PromotionService {
    Promotion generatePromotion(VisitDate visitDate, Orders orders);
    OrderPriceDto generateOrderPriceDto(Orders orders, Promotion promotion);
    PromotionDto generatePromotionDto(Promotion promotion);


}
