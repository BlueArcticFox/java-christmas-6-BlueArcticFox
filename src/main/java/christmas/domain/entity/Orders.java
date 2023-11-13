package christmas.domain.entity;

import static christmas.message.ErrorMessage.INVALID_MENU_MESSAGE;

import christmas.util.ExceptionUtil;
import christmas.validation.OrdersValidator;
import java.util.EnumMap;
import java.util.Map;

public class Orders extends OrdersValidator {
    private final Map<Menu, Integer> orderGroup = new EnumMap<>(Menu.class);

    public Orders() {
        init();
    }

    private void init() {
        for (Menu menu : Menu.values()) {
            orderGroup.put(menu, 0);
        }
    }

    public void addOrder(Menu menu, Integer quantity) {
        validateDuplicates(orderGroup, menu);
        orderGroup.put(menu, quantity);
        validateQuantity(orderGroup);
    }

    public int getTotalPrice() {
        int prize = 0;
        for(Menu menu: orderGroup.keySet()) {
            prize += menu.getTotalPrice(orderGroup.get(menu));
        }
        return prize;
    }

    public int getNumberOfOrders() {
        int count = 0;
        for(int orderNumber: orderGroup.values()) {
            count += orderNumber;
        }
        return count;
    }

    public int getNumberOfSection(String section) {
        int count = 0;
        for(Menu menu: orderGroup.keySet()) {
            if(menu.getSection().equals(section)) {
                count += orderGroup.get(menu);
            }
        }
        return count;
    }

    public Map<Menu, Integer> getOrders() {
        return orderGroup;
    }
}
