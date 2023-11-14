package christmas.configuration;

import christmas.controller.EventPlanerController;
import christmas.repository.MemoryScheduleRepository;
import christmas.repository.Repository;
import christmas.service.OrdersService;
import christmas.service.OrdersServiceImpl;
import christmas.service.PromotionService;
import christmas.service.PromotionServiceImpl;
import christmas.service.ScheduleService;
import christmas.service.ScheduleServiceImpl;
import christmas.view.ConsoleInputView;
import christmas.view.ConsoleOutputView;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig implements Config {
    public static AppConfig getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public EventPlanerController eventPlanerController() {
        return LazyHolder.eventPlanerController;
    }

    @Override
    public OrdersService ordersService() {
        return LazyHolder.ordersService;
    }

    @Override
    public PromotionService promotionService() {
        return LazyHolder.promotionService;
    }

    @Override
    public ScheduleService scheduleService() {
        return LazyHolder.scheduleService;
    }

    @Override
    public InputView inputView() {
        return LazyHolder.inputView;
    }

    @Override
    public OutputView outputView() {
        return LazyHolder.outputView;
    }

    @Override
    public Repository scheduleRepository() {
        return LazyHolder.scheduleRepository;
    }

    private static class LazyHolder {
        private static final AppConfig INSTANCE = new AppConfig();
        private static final InputView inputView = createInputView();
        private static final OutputView outputView = createOutputView();
        private static final OrdersService ordersService = createOrdersService();
        private static final Repository scheduleRepository = createScheduleRepository();
        private static final PromotionService promotionService = createPromotionService();
        private static final ScheduleService scheduleService = createScheduleService();
        private static final EventPlanerController eventPlanerController = createEventPlanerController();

        private static EventPlanerController createEventPlanerController() {
            return new EventPlanerController(
                    inputView,
                    outputView,
                    ordersService,
                    promotionService,
                    scheduleService
            );
        }

        private static InputView createInputView() {
            return new ConsoleInputView();
        }

        private static OutputView createOutputView() {
            return new ConsoleOutputView();
        }

        private static Repository createScheduleRepository() {
            return new MemoryScheduleRepository();
        }

        private static OrdersService createOrdersService() {
            return new OrdersServiceImpl();
        }

        private static PromotionService createPromotionService() {
            return new PromotionServiceImpl();
        }

        private static ScheduleService createScheduleService() {
            return new ScheduleServiceImpl(scheduleRepository);
        }
    }
}
