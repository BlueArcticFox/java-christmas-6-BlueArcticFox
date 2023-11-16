package christmas.configuration;

import christmas.controller.EventPlanerController;
import christmas.repository.Repository;
import christmas.service.OrdersService;
import christmas.service.PromotionService;
import christmas.service.ScheduleService;
import christmas.view.InputView;
import christmas.view.OutputView;

public interface Config {
    EventPlanerController eventPlanerController();
    OrdersService ordersService();
    PromotionService promotionService();
    ScheduleService scheduleService();
    InputView inputView();
    OutputView outputView();
    Repository scheduleRepository();
}
