package christmas;

import christmas.configuration.AppConfig;
import christmas.configuration.Config;
import christmas.controller.EventPlanerController;

public class Application {
    public static void main(String[] args) {
        Config config = generateConfig();
        EventPlanerController eventPlanerController = generateEventPlanerController(config);
        eventPlanerController.runEventPlaner();
    }

    private static Config generateConfig() {
        return AppConfig.getInstance();
    }

    private static EventPlanerController generateEventPlanerController(Config config) {
        return config.eventPlanerController();
    }
}
