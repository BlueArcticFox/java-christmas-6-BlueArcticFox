package christmas.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.Menu;
import christmas.domain.entity.MyGiveaway;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyGiveawayTest {
    @DisplayName("증정대상일때 샴페인 증정 테스트")
    @Test
    void myGiveawayTest_1() {
        MyGiveaway myGiveaway = new MyGiveaway(120000);
        List<Menu> giveawayMenu = myGiveaway.getAvailableGiveaway();
        assertEquals(giveawayMenu, List.of(Menu.CHAMPAGNE));
    }

    @DisplayName("증정대상이 아닐때 테스트")
    @Test
    void myGiveawayTest_2() {
        MyGiveaway myGiveaway = new MyGiveaway(119999);
        List<Menu> giveawayMenu = myGiveaway.getAvailableGiveaway();
        assertEquals(giveawayMenu, List.of());
    }
}
