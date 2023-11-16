package christmas.domain.entity;

import static christmas.domain.entity.Menu.CHAMPAGNE;

public enum Giveaway {
    GIVEAWAY_0(CHAMPAGNE, 1, 120000);

    private final Menu menu;
    private final int quantity;
    private final int condition;
    private Giveaway(Menu menu, int quantity, int condition) {
        this.menu = menu;
        this.quantity = quantity;
        this.condition = condition;
    }

    public boolean satisfyCondition(int value) {
        return value >= condition;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
