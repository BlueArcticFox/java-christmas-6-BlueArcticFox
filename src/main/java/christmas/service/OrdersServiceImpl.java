package christmas.service;

import static christmas.configuration.IntegerConstant.ZERO;
import static christmas.configuration.StringConstant.DELIMITER_DASH;
import static christmas.configuration.StringConstant.DRINK;
import static christmas.domain.dto.DtoMapper.toOrderDto;
import static christmas.message.ErrorMessage.INVALID_MENU_MESSAGE;

import christmas.domain.dto.OrdersDto;
import christmas.domain.entity.Menu;
import christmas.domain.entity.Orders;
import christmas.domain.entity.VisitDate;
import christmas.util.ExceptionUtil;
import christmas.util.IntegerUtil;
import christmas.util.MenuUtil;
import christmas.util.StringUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrdersServiceImpl implements OrdersService {
    @Override
    public Orders generateOrders(List<String> values) {
        Orders orders = Orders.create();
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
        if(orders.getNumberOfOrders() == orders.getNumberOfSection(DRINK.getValue())) {
            ExceptionUtil.throwIllegalArgumentException(INVALID_MENU_MESSAGE.getMessage());
        }
    }

    @Override
    public OrdersDto generateOrdersDto(VisitDate visitDate, Map<Menu, Integer> orders) {
        Map<String, Integer> ordersForDto = new LinkedHashMap<String, Integer>();
        for(Menu menu : orders.keySet()) {
            int quantity = orders.get(menu);
            if(quantity > ZERO.getValue()) {
                ordersForDto.put(menu.getName(), quantity);
            }
        }
        return toOrderDto(visitDate.getDate(), ordersForDto);
    }
}
