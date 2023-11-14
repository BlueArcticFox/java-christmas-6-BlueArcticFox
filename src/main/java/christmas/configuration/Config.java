package christmas.configuration;

import christmas.controller.EventPlanerController;
import christmas.service.OrdersService;
import christmas.service.PromotionService;
import christmas.view.InputView;
import christmas.view.OutputView;

public interface Config {
    EventPlanerController eventPlanerController();
    OrdersService ordersService();
    PromotionService promotionService();
    InputView inputView();
    OutputView outputView();
}
