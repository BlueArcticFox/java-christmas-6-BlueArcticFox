package christmas.domain.entity;

import static christmas.domain.entity.Menu.CHAMPAGNE;

public enum GiveawayCondition {
    GIVEAWAY_0(CHAMPAGNE, 120000);

    private final Menu menu;
    private final int condition;
    private
    GiveawayCondition(Menu menu, int condition) {
        this.menu = menu;
        this.condition = condition;
    }

    public boolean satisfyCondition(int value) {
        return value >= condition;
    }

    public Menu getMenu() {
        return menu;
    }
}
