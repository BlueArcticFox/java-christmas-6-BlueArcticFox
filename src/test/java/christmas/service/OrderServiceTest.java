package christmas.service;

import static christmas.configuration.StringConstant.APPETIZER;
import static christmas.configuration.StringConstant.DESSERT;
import static christmas.configuration.StringConstant.DRINK;
import static christmas.configuration.StringConstant.MAIN_DISH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.dto.OrdersDto;
import christmas.domain.entity.Menu;
import christmas.domain.entity.Orders;
import christmas.domain.entity.VisitDate;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    private Orders orders;
    private OrdersService ordersService;
    @BeforeEach
    public void setUp() {
        orders = new Orders();
        ordersService = new OrdersService();
        orders.addOrder(Menu.TAPAS, 5);
        orders.addOrder(Menu.BBQ_RIBS, 3);
        orders.addOrder(Menu.SEAFOOD_PASTA, 1);
        orders.addOrder(Menu.ICE_CREAM, 2);
        orders.addOrder(Menu.RED_WINE, 1);
    }

    @DisplayName("음료만 주문할 경우 예외가 발생한다.")
    @Test
    void InvalidNumberInteger() {
        assertThatThrownBy(() -> ordersService.generateOrders(List.of("제로콜라-3", "레드와인-2")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("애피타이저 개수 반환 테스트")
    @Test
    void appetizerTest() {
        assertEquals(orders.getNumberOfSection(APPETIZER.getValue()), 5);
    }

    @DisplayName("메인 개수 반환 테스트")
    @Test
    void mainDishTest() {
        assertEquals(orders.getNumberOfSection(MAIN_DISH.getValue()), 4);
    }

    @DisplayName("디저트 개수 반환 테스트")
    @Test
    void dessertTest() {
        assertEquals(orders.getNumberOfSection(DESSERT.getValue()), 2);
    }

    @DisplayName("음료 개수 반환 테스트")
    @Test
    void drinkTest() {
        assertEquals(orders.getNumberOfSection(DRINK.getValue()), 1);
    }

    @DisplayName("총 음식 개수 반환 테스트")
    @Test
    void foodTest() {
        assertEquals(orders.getNumberOfOrders(), 12);
    }

    @DisplayName("전체 가격 계산 테스트")
    @Test
    void totalPriceTest() {
        assertEquals(orders.getTotalPrice(), 294500);
    }

    @DisplayName("OrderDto 변환 테스트")
    @Test
    void OrderDtoTest() {
        OrdersDto ordersDto = ordersService.generateOrdersDto(new VisitDate(20), orders.getOrders());
        OrdersDto expected = new OrdersDto(20,
                    Map.of(
                            Menu.TAPAS.getName(), 5,
                            Menu.BBQ_RIBS.getName(), 3,
                            Menu.SEAFOOD_PASTA.getName(), 1,
                            Menu.ICE_CREAM.getName(), 2,
                            Menu.RED_WINE.getName(), 1
                    )
            );
        assertEquals(ordersDto.getOrders(), expected.getOrders());
        assertEquals(ordersDto.getVisitDate(), expected.getVisitDate());
    }
}
