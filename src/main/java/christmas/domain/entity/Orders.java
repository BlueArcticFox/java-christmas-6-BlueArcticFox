package christmas.domain.entity;

import static christmas.message.ErrorMessage.INVALID_MENU_MESSAGE;

import christmas.util.ExceptionUtil;
import christmas.validation.OrdersValidator;
import java.util.EnumMap;
import java.util.Map;

public class Orders extends OrdersValidator {
    private final Map<Menu, Integer> orders = new EnumMap<>(Menu.class);

    public Orders() {
        init();
    }

    private void init() {
        for (Menu menu : Menu.values()) {
            orders.put(menu, 0);
        }
    }

    public void addOrder(Menu menu, Integer quantity) {
        validateDuplicates(orders, menu);
        orders.put(menu, quantity);
        validateQuantity(orders);
    }
}
