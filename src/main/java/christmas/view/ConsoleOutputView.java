package christmas.view;

import static christmas.configuration.PatternConstant.THOUSAND_SEPARATOR;
import static christmas.message.OutputMessage.BENEFIT_MESSAGE;
import static christmas.message.OutputMessage.EVENT_BADGE_MESSAGE;
import static christmas.message.OutputMessage.EXPECTED_PRICE_AFTER_DISCOUNT_MESSAGE;
import static christmas.message.OutputMessage.GIVEAWAY_MENU_MESSAGE;
import static christmas.message.OutputMessage.MENU_UNIT_MESSAGE;
import static christmas.message.OutputMessage.NULL_MESSAGE;
import static christmas.message.OutputMessage.ORDER_MENU_MESSAGE;
import static christmas.message.OutputMessage.PRICE_UNIT_MESSAGE;
import static christmas.message.OutputMessage.PROMOTION_PREVIEW_MESSAGE;
import static christmas.message.OutputMessage.TOTAL_BENEFIT_MESSAGE;
import static christmas.message.OutputMessage.TOTAL_PRICE_BEFORE_DISCOUNT_MESSAGE;
import static christmas.message.OutputMessage.WELCOME_MESSAGE;

import christmas.domain.dto.OrderPriceDto;
import christmas.domain.dto.OrdersDto;
import christmas.domain.dto.PromotionDto;
import christmas.util.OutputUtil;
import christmas.util.StringUtil;
import java.util.Map;
import javax.print.DocFlavor.STRING;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printWelcome() {
        System.out.println(WELCOME_MESSAGE.getMessage());
    }

    @Override
    public void printPromotionPreview(OrdersDto ordersDto) {
        System.out.println(String.format(
                PROMOTION_PREVIEW_MESSAGE.getMessage(),
                ordersDto.getVisitDate()
                ));
        OutputUtil.printEmptyLine();
    }

    @Override
    public void printOrders(OrdersDto ordersDto) {
        System.out.println(ORDER_MENU_MESSAGE.getMessage());
        Map<String, Integer> orders = ordersDto.getOrders();
        for(String order : orders.keySet()) {
            System.out.println(String.format(
                    MENU_UNIT_MESSAGE.getMessage(),
                    order,
                    orders.get(order)
            ));
        }
        OutputUtil.printEmptyLine();
    }

    @Override
    public void printTotalPriceBeforeDiscount(OrderPriceDto orderPriceDto) {
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT_MESSAGE.getMessage());
        int beforePrice = orderPriceDto.getTotalPriceBeforeDiscount();
        System.out.println(String.format(
                PRICE_UNIT_MESSAGE.getMessage(),
                formatNumber(beforePrice)
        ));
        OutputUtil.printEmptyLine();
    }

    @Override
    public void printGiveaway(PromotionDto promotionDto) {
        System.out.println(GIVEAWAY_MENU_MESSAGE.getMessage());
        Map<String, Integer> giveaway = promotionDto.getGiveaway();
        if(giveaway.isEmpty()) {
            System.out.println(NULL_MESSAGE.getMessage());
        }
        for(String name : giveaway.keySet()) {
            System.out.println(String.format(
                    MENU_UNIT_MESSAGE.getMessage(),
                    name,
                    giveaway.get(name)
            ));
        }
        OutputUtil.printEmptyLine();
    }

    @Override
    public void printBenefit(PromotionDto promotionDto) {
        System.out.println(BENEFIT_MESSAGE.getMessage());
        Map<String, Integer> benefit = promotionDto.getBenefit();
        if(benefit.isEmpty()) {
            System.out.println(NULL_MESSAGE.getMessage());
        }
        for(String message : benefit.keySet()) {
            System.out.println(String.format(
                    message,
                    formatNumber(benefit.get(message))
            ));
        }
        OutputUtil.printEmptyLine();
    }

    @Override
    public void printTotalBenefit(OrderPriceDto orderPriceDto) {
        System.out.println(TOTAL_BENEFIT_MESSAGE.getMessage());
        int totalBenefit = orderPriceDto.getTotalBenefit();
        System.out.println(String.format(
                PRICE_UNIT_MESSAGE.getMessage(),
                formatNumber(totalBenefit)
        ));
        OutputUtil.printEmptyLine();
    }

    @Override
    public void printExpectedPriceAfterDiscount(OrderPriceDto orderPriceDto) {
        System.out.println(EXPECTED_PRICE_AFTER_DISCOUNT_MESSAGE.getMessage());
        int expectedPrice = orderPriceDto.getExpectedPriceAfterDiscount();
        System.out.println(String.format(
                PRICE_UNIT_MESSAGE.getMessage(),
                formatNumber(expectedPrice)
        ));
        OutputUtil.printEmptyLine();
    }

    @Override
    public void printEventBadge(PromotionDto promotionDto) {
        System.out.println(EVENT_BADGE_MESSAGE.getMessage());
        System.out.println(promotionDto.getBadge());
    }

    private String formatNumber(int value) {
        return StringUtil.formatNumber(value, THOUSAND_SEPARATOR.getValue());
    }
}
