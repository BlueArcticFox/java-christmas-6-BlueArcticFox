package christmas.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuUtilTest {

    @DisplayName("정상 입력에 대한 메뉴 반환")
    @Test
    void goodGetMenuByNameTest() {
        assertEquals(MenuUtil.getMenuByName("타파스"), Menu.TAPAS);
    }

    @DisplayName("비정상 입력에 대한 예외 발생")
    @Test
    void badGetMenuByNameTest() {
        assertThatThrownBy(() -> MenuUtil.getMenuByName("오징어"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
