package christmas.validation;

import static christmas.configuration.IntegerConstant.MAX_QUANTITY;
import static christmas.message.ErrorMessage.INVALID_MENU_MESSAGE;
import static christmas.message.ErrorMessage.LIMIT_MENU_SELECTION_MESSAGE;

import christmas.domain.entity.Menu;
import christmas.util.ExceptionUtil;
import java.util.Map;

public class OrdersValidator {
    protected void validateDuplicates(Map<Menu, Integer> orders, Menu menu) {
        if(!(orders.get(menu) == 0)) {
            ExceptionUtil.throwIllegalArgumentException(INVALID_MENU_MESSAGE.getMessage());
        }
    }

    protected void validateQuantity(Map<Menu, Integer> orders) {
        int totalQuantity = orders.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        if(totalQuantity > MAX_QUANTITY.getValue()) {
            ExceptionUtil.throwIllegalArgumentException(LIMIT_MENU_SELECTION_MESSAGE.getMessage());
        }
    }
}
