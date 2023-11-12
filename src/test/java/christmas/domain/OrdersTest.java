package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import christmas.domain.entity.Menu;
import christmas.domain.entity.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrdersTest {
    private Orders orders;
    @BeforeEach
    public void setUp() {
        orders = new Orders();
    }

    @DisplayName("정상 메뉴 추가에 따른 테스트")
    @Test
    void goodAddOrderTest() {
        assertThatCode(() -> orders.addOrder(Menu.TAPAS, 5))
                .doesNotThrowAnyException();
    }

    @DisplayName("중복 메뉴 추가에 따른 예외 테스트")
    @Test
    void badAddOrderTest_1() {
        orders.addOrder(Menu.TAPAS, 5);
        assertThatThrownBy(() -> orders.addOrder(Menu.TAPAS, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 개수 한계 초과에 따른 예외 테스트")
    @Test
    void badAddOrderTest_2() {
        orders.addOrder(Menu.TAPAS, 5);
        assertThatThrownBy(() -> orders.addOrder(Menu.ICE_CREAM, 16))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
