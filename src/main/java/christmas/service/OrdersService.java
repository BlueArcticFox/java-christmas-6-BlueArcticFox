package christmas.service;

import christmas.domain.dto.OrdersDto;
import christmas.domain.entity.Menu;
import christmas.domain.entity.Orders;
import christmas.domain.entity.VisitDate;
import java.util.List;
import java.util.Map;

public interface OrdersService {
    Orders generateOrders(List<String> values);
    OrdersDto generateOrdersDto(VisitDate visitDate, Map<Menu, Integer> orders);
}
