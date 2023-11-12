package christmas;

import christmas.controller.EventPlanerController;

public class Application {
    public static void main(String[] args) {
        EventPlanerController controller = new EventPlanerController();
        controller.runEventPlaner();
    }
}
