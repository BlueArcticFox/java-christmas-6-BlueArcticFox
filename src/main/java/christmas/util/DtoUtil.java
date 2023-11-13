package christmas.util;

import static christmas.configuration.IntegerConstant.ZERO;
import static christmas.domain.dto.DtoMapper.toOrderPriceDto;
import static christmas.domain.dto.DtoMapper.toPromotionDto;

import christmas.domain.dto.OrderPriceDto;
import christmas.domain.dto.PromotionDto;
import christmas.domain.entity.EventBadge;
import java.util.HashMap;

public class DtoUtil {

    public static OrderPriceDto getNullOrderPriceDto(int totalPrice){
        return toOrderPriceDto(totalPrice, ZERO.getValue(), totalPrice);
    }

    public static PromotionDto getNullPromotionDto(){
        return toPromotionDto(
                new HashMap<String, Integer>(),
                new HashMap<String, Integer>(),
                EventBadge.NULL_BADGE.getBadgeName()
        );
    }
}
