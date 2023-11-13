package christmas.service;

import static christmas.configuration.StringConstant.DELIMITER_DASH;
import static christmas.configuration.StringConstant.DRINK;
import static christmas.message.ErrorMessage.INVALID_MENU_MESSAGE;

import christmas.domain.entity.Menu;
import christmas.domain.entity.Orders;
import christmas.util.ExceptionUtil;
import christmas.util.IntegerUtil;
import christmas.util.MenuUtil;
import christmas.util.StringUtil;
import java.util.List;
import java.util.Map;

public class OrdersService {
    public Orders generateOrders(List<String> values) {
        Orders orders = new Orders();
        for(String value : values) {
            List<String> splitValue = StringUtil.splitBy(value, DELIMITER_DASH.getValue());

            Menu menu = MenuUtil.getMenuByName(splitValue.get(0));
            int quantity = IntegerUtil.convertInt(splitValue.get(1),INVALID_MENU_MESSAGE.getMessage());

            orders.addOrder(menu, quantity);
        }
        validateAllDrinks(orders);
        return orders;
    }

    private void validateAllDrinks(Orders orders) {
        if(getNumberOfOrders(orders) == getNumberOfSection(orders, DRINK.getValue())) {
            ExceptionUtil.throwIllegalArgumentException(INVALID_MENU_MESSAGE.getMessage());
        }
    }

    public int getTotalPrice(Orders orders) {
        int prize = 0;
        Map<Menu, Integer> orderGroup = orders.getOrders();
        for(Menu menu: orderGroup.keySet()) {
            prize += menu.getTotalPrice(orderGroup.get(menu));
        }
        return prize;
    }

    public int getNumberOfOrders(Orders orders) {
        int count = 0;
        Map<Menu, Integer> orderGroup = orders.getOrders();
        for(int orderNumber: orderGroup.values()) {
            count += orderNumber;
        }
        return count;
    }

    public int getNumberOfSection(Orders orders, String section) {
        int count = 0;
        Map<Menu, Integer> orderGroup = orders.getOrders();
        for(Menu menu: orderGroup.keySet()) {
            if(menu.getSection().equals(section)) {
                count += orderGroup.get(menu);
            }
        }
        return count;
    }
}
