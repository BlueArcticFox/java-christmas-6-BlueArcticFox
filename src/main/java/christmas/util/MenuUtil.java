package christmas.util;

import static christmas.message.ErrorMessage.INVALID_MENU_MESSAGE;

import christmas.domain.entity.Menu;

public class MenuUtil {
    public static Menu getMenuByName(String value) {
        for (Menu menu : Menu.values()) {
            String name = menu.getName();
            if (name.equals(value)) {
                return menu;
            }
        }
        ExceptionUtil.throwIllegalArgumentException(INVALID_MENU_MESSAGE.getMessage());
        return null;
    }
}
