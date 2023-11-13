package christmas.service;

import static christmas.configuration.StringConstant.APPETIZER;
import static christmas.configuration.StringConstant.DESSERT;
import static christmas.configuration.StringConstant.DRINK;
import static christmas.configuration.StringConstant.MAIN_DISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.Menu;
import christmas.domain.entity.Orders;
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

    @DisplayName("애피타이저 개수 반환 테스트")
    @Test
    void appetizerTest() {
        assertEquals(ordersService.getNumberOfSection(orders, APPETIZER.getValue()), 5);
    }

    @DisplayName("메인 개수 반환 테스트")
    @Test
    void mainDishTest() {
        assertEquals(ordersService.getNumberOfSection(orders, MAIN_DISH.getValue()), 4);
    }

    @DisplayName("디저트 개수 반환 테스트")
    @Test
    void dessertTest() {
        assertEquals(ordersService.getNumberOfSection(orders, DESSERT.getValue()), 2);
    }

    @DisplayName("음료 개수 반환 테스트")
    @Test
    void drinkTest() {
        assertEquals(ordersService.getNumberOfSection(orders, DRINK.getValue()), 1);
    }

    @DisplayName("총 음식 개수 반환 테스트")
    @Test
    void foodTest() {
        assertEquals(ordersService.getNumberOfOrders(orders), 12);
    }
}
