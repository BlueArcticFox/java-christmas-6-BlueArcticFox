package christmas.service;

import static christmas.message.BenefitMessage.CHRISTMAS_D_DAY_DISCOUNT_MESSAGE;
import static christmas.message.BenefitMessage.GIVEAWAY_EVENT_MESSAGE;
import static christmas.message.BenefitMessage.SPECIAL_DISCOUNT_MESSAGE;
import static christmas.message.BenefitMessage.WEEKDAY_DISCOUNT_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.dto.OrderPriceDto;
import christmas.domain.dto.PromotionDto;
import christmas.domain.entity.Menu;
import christmas.domain.entity.Orders;
import christmas.domain.entity.Promotion;
import christmas.domain.entity.VisitDate;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PromotionServiceTest {
    private VisitDate visitDate;
    private Orders orders;
    private PromotionService promotionService;
    private Promotion promotion;
    @BeforeEach
    public void setUp() {
        visitDate = VisitDate.create(24);
        orders = Orders.create();
        promotionService = new PromotionServiceImpl();
        orders.addOrder(Menu.BBQ_RIBS, 3);
        orders.addOrder(Menu.CHOCOLATE_CAKE, 5);
        promotion = promotionService.generatePromotion(visitDate, orders);
    }

    @DisplayName("Promotion 생성 메서드 테스트")
    @Test
    void generatePromotionTest() {
        promotion = promotionService.generatePromotion(visitDate, orders);
        Promotion expected = Promotion.create(visitDate, orders);
        assertEquals(promotion.getMyDiscount().getAllDiscount(), expected.getMyDiscount().getAllDiscount());
        assertEquals(promotion.getMyEventBadge().getBadge(), expected.getMyEventBadge().getBadge());
        assertEquals(promotion.getTotalBenefit(), expected.getTotalBenefit());
    }

    @DisplayName("OrderPriceDto변환 테스트")
    @Test
    void orderPriceDtoTest() {
        OrderPriceDto orderPriceDto = promotionService.generateOrderPriceDto(orders, promotion);
        assertEquals(orderPriceDto.getTotalPriceBeforeDiscount(), 237000);
        assertEquals(orderPriceDto.getTotalBenefit(), -39415);
        assertEquals(orderPriceDto.getExpectedPriceAfterDiscount(), 222585);
    }

    @DisplayName("PromotionDto변환 테스트")
    @Test
    void promotionDtoTest() {
        PromotionDto promotionDto = promotionService.generatePromotionDto(promotion);
        assertEquals(promotionDto.getGiveaway(), Map.of("샴페인", 1));
        assertEquals(promotionDto.getBenefit(), Map.of(
                CHRISTMAS_D_DAY_DISCOUNT_MESSAGE.getMessage(), -3300,
                WEEKDAY_DISCOUNT_MESSAGE.getMessage(), -10115,
                SPECIAL_DISCOUNT_MESSAGE.getMessage(), -1000,
                GIVEAWAY_EVENT_MESSAGE.getMessage(), -25000
        ));
        assertEquals(promotionDto.getBadge(), "산타");
    }

    @DisplayName("OrderPriceDto변환 null 테스트")
    @Test
    void nullOrderPriceDtoTest() {
        OrderPriceDto orderPriceDto = promotionService.generateOrderPriceDto(orders, null);
        assertEquals(orderPriceDto.getTotalPriceBeforeDiscount(), 237000);
        assertEquals(orderPriceDto.getTotalBenefit(), 0);
        assertEquals(orderPriceDto.getExpectedPriceAfterDiscount(), 237000);
    }

    @DisplayName("10000원 이하(9000원)의 promotion null 반환 테스트")
    @Test
    void underMinPriceTest() {
        orders = Orders.create();
        orders.addOrder(Menu.MUSHROOM_SOUP, 1);
        orders.addOrder(Menu.ZERO_COLA, 1);
        Promotion promotion = promotionService.generatePromotion(visitDate, orders);
        Promotion expected = null;
        assertEquals(promotion, expected);
    }

    @DisplayName("PromotionDto변환 null 테스트")
    @Test
    void nullPromotionDtoTest() {
        PromotionDto promotionDto = promotionService.generatePromotionDto(null);
        assertEquals(promotionDto.getGiveaway(), Map.of());
        assertEquals(promotionDto.getBenefit(), Map.of());
        assertEquals(promotionDto.getBadge(), "없음");
    }
}
