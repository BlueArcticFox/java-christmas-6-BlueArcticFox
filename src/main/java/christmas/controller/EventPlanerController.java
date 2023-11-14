package christmas.controller;

import christmas.domain.dto.OrderPriceDto;
import christmas.domain.dto.OrdersDto;
import christmas.domain.dto.PromotionDto;
import christmas.domain.entity.Orders;
import christmas.domain.entity.Promotion;
import christmas.domain.entity.VisitDate;
import christmas.service.OrdersService;
import christmas.service.OrdersServiceImpl;
import christmas.service.PromotionService;
import christmas.service.PromotionServiceImpl;
import christmas.view.ConsoleInputView;
import christmas.view.ConsoleOutputView;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventPlanerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final OrdersService ordersService;
    private final PromotionService promotionService;

    public EventPlanerController(InputView inputView,
                                 OutputView outputView,
                                 OrdersService ordersService,
                                 PromotionService promotionService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ordersService = ordersService;
        this.promotionService = promotionService;
    }

    public void runEventPlaner() {
        outputView.printWelcome();
        VisitDate visitDate = decideVisitDate();
        Orders orders = decideOrders();
        Promotion promotion = promotionService.generatePromotion(visitDate, orders);

        OrdersDto ordersDto = ordersService.generateOrdersDto(visitDate, orders.getOrders());
        OrderPriceDto orderPriceDto = promotionService.generateOrderPriceDto(orders, promotion);
        PromotionDto promotionDto = promotionService.generatePromotionDto(promotion);

        printResult(ordersDto, orderPriceDto, promotionDto);
    }

    private VisitDate decideVisitDate() {
        try {
            int input = inputView.inputDate();
            return new VisitDate(input);
        } catch (IllegalArgumentException e) {
            return decideVisitDate();
        }
    }

    private Orders decideOrders() {
        try {
            List<String> splitInput = inputView.inputOrders();
            return ordersService.generateOrders(splitInput);
        } catch (IllegalArgumentException e) {
            return decideOrders();
        }
    }

    private void printResult(OrdersDto ordersDto, OrderPriceDto orderPriceDto, PromotionDto promotionDto) {
        outputView.printPromotionPreview(ordersDto);
        outputView.printOrders(ordersDto);
        outputView.printTotalPriceBeforeDiscount(orderPriceDto);
        outputView.printGiveaway(promotionDto);
        outputView.printBenefit(promotionDto);
        outputView.printTotalBenefit(orderPriceDto);
        outputView.printExpectedPriceAfterDiscount(orderPriceDto);
        outputView.printEventBadge(promotionDto);
    }
}
