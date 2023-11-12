package christmas.controller;

import christmas.domain.entity.Orders;
import christmas.domain.entity.VisitDate;
import christmas.service.OrdersService;
import christmas.view.ConsoleInputView;
import christmas.view.ConsoleOutputView;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventPlanerController {
    InputView inputView = new ConsoleInputView();
    OutputView outputView = new ConsoleOutputView();
    OrdersService ordersService = new OrdersService();

    public void runEventPlaner() {
        outputView.printWelcome();
        VisitDate date = decideDate();
        Orders orders = decideOrders();
    }

    private VisitDate decideDate() {
        try {
            int input = inputView.inputDate();
            return new VisitDate(input);
        } catch (IllegalArgumentException e) {
            return decideDate();
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
}
