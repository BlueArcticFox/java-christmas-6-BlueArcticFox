package christmas.controller;

import static christmas.configuration.BooleanConstant.NO;

import christmas.domain.dto.OrderPriceDto;
import christmas.domain.dto.OrdersDto;
import christmas.domain.dto.PromotionDto;
import christmas.domain.entity.Orders;
import christmas.domain.entity.Promotion;
import christmas.domain.entity.Schedule;
import christmas.domain.entity.VisitDate;
import christmas.service.OrdersService;
import christmas.service.PromotionService;
import christmas.service.ScheduleService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventPlanerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final OrdersService ordersService;
    private final PromotionService promotionService;
    private final ScheduleService scheduleService;

    public EventPlanerController(InputView inputView,
                                 OutputView outputView,
                                 OrdersService ordersService,
                                 PromotionService promotionService,
                                 ScheduleService scheduleService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ordersService = ordersService;
        this.promotionService = promotionService;
        this.scheduleService = scheduleService;
    }

    public void runEventPlaner() {
        outputView.printWelcome();
        VisitDate visitDate = decideVisitDate();
        Orders orders = decideOrders();
        Promotion promotion = promotionService.generatePromotion(visitDate, orders);

        OrdersDto ordersDto = ordersService.generateOrdersDto(visitDate, orders.getOrderGroup());
        OrderPriceDto orderPriceDto = promotionService.generateOrderPriceDto(orders, promotion);
        PromotionDto promotionDto = promotionService.generatePromotionDto(promotion);

        printResult(ordersDto, orderPriceDto, promotionDto);
        Schedule schedule = Schedule.create(visitDate, orders, promotion);
        Long scheduleId = scheduleService.saveSchedule(schedule);

        rePlan(NO.getValue());
    }

    private VisitDate decideVisitDate() {
        try {
            int input = inputView.inputDate();
            return VisitDate.create(input);
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

    private void rePlan(boolean isContinue) {
        if (isContinue) {
            runEventPlaner();
        }
    }
}
