package christmas.service;

import static christmas.configuration.IntegerConstant.MIN_PRICE;
import static christmas.configuration.IntegerConstant.ZERO;
import static christmas.domain.dto.DtoMapper.toOrderPriceDto;
import static christmas.domain.dto.DtoMapper.toPromotionDto;

import christmas.domain.dto.OrderPriceDto;
import christmas.domain.dto.PromotionDto;
import christmas.domain.entity.Menu;
import christmas.domain.entity.Orders;
import christmas.domain.entity.Promotion;
import christmas.domain.entity.VisitDate;
import christmas.domain.entity.discount.MyDiscount;
import christmas.util.DtoUtil;
import java.util.LinkedHashMap;
import java.util.Map;

public class PromotionService {
    public Promotion generatePromotion(VisitDate visitDate, Orders orders) {
        if(orders.getTotalPrice() >= MIN_PRICE.getValue()) {
            return new Promotion(visitDate, orders);
        }
        return null;
    }

    public OrderPriceDto generateOrderPriceDto(Orders orders, Promotion promotion) {
        int totalPrice = orders.getTotalPrice();
        if(promotion == null) {
            return DtoUtil.getNullOrderPriceDto(totalPrice);
        }

        int totalBenefit = promotion.getTotalBenefit();
        int expectedPrice = totalPrice - promotion.getMyDiscount().getAllDiscount();
        return toOrderPriceDto(totalPrice, totalBenefit, expectedPrice);
    }

    public PromotionDto generatePromotionDto(Promotion promotion) {
        if(promotion == null) {
            return DtoUtil.getNullPromotionDto();
        }

        Map<String, Integer> giveawayForDto = decideGiveawayForDto(
                promotion.getMyGiveaway()
                .getAvailableGiveaway());
        Map<String, Integer> discountForDto = decideDiscountForDto(promotion);
        String badgeForDto = promotion.getMyEventBadge().getBadge().getBadgeName();
        return toPromotionDto(giveawayForDto, discountForDto, badgeForDto);
    }

    private Map<String, Integer> decideGiveawayForDto(Map<Menu, Integer> giveaway) {
        Map<String, Integer> giveawayForDto = new LinkedHashMap<String, Integer>();
        for(Menu menu : giveaway.keySet()) {
            int quantity = giveaway.get(menu);
            if(quantity > ZERO.getValue()) {
                giveawayForDto.put(menu.getName(), quantity);
            }
        }
        return giveawayForDto;
    }

    private Map<String, Integer> decideDiscountForDto(Promotion promotion) {
        Map<String, Integer> discountForDto = new LinkedHashMap<String, Integer>();
        MyDiscount myDiscount = promotion.getMyDiscount();

        int benefit = myDiscount.getD_DayDiscount().getDiscount();
        putDiscountForDto(discountForDto, myDiscount.getD_DayDiscount().getMessage(), benefit);

        benefit = myDiscount.getWeekDiscount().getDiscount();
        putDiscountForDto(discountForDto, myDiscount.getWeekDiscount().getMessage(), benefit);

        benefit = myDiscount.getSpecialDiscount().getDiscount();
        putDiscountForDto(discountForDto, myDiscount.getSpecialDiscount().getMessage(), benefit);

        benefit = calcGiveawayBenefit(promotion.getMyGiveaway().getAvailableGiveaway());
        putDiscountForDto(discountForDto, promotion.getMyGiveaway().getMessage(), benefit);

        return discountForDto;
    }

    private void putDiscountForDto(Map<String, Integer> discountFotDto, String message, int discount) {
        if(discount > ZERO.getValue()) {
            discountFotDto.put(message, discount);
        }
    }

    private int calcGiveawayBenefit(Map<Menu, Integer> giveaway) {
        int benefit = ZERO.getValue();
        for(Menu menu : giveaway.keySet()) {
            benefit += menu.getPrice() * giveaway.get(menu);
        }
        return benefit;
    }
}
