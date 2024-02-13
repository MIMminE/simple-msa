package my.project.msa.orderservice.service;

import my.project.msa.orderservice.dto.OrderDto;
import my.project.msa.orderservice.entity.OrderEntity;

public interface OrderService {
    OrderDto createdOrder(OrderDto orderDetails);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getOrdersByUserId(String userId);
}
