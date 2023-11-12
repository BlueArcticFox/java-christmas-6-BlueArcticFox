package christmas.service;

import static christmas.configuration.StringConstant.DELIMITER_DASH;
import static christmas.message.ErrorMessage.INVALID_MENU_MESSAGE;

import christmas.domain.entity.Menu;
import christmas.domain.entity.Orders;
import christmas.util.IntegerUtil;
import christmas.util.MenuUtil;
import christmas.util.StringUtil;
import java.util.List;

public class OrdersService {
    public Orders generateOrders(List<String> values) {
        Orders orders = new Orders();
        for(String value : values) {
            List<String> splitValue = StringUtil.splitBy(value, DELIMITER_DASH.getValue());

            Menu menu = MenuUtil.getMenuByName(splitValue.get(0));
            int quantity = IntegerUtil.convertInt(splitValue.get(1),INVALID_MENU_MESSAGE.getMessage());

            orders.addOrder(menu, quantity);
        }
        return orders;
    }
}
