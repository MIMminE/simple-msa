package my.project.msa.orderservice.service;

import lombok.extern.slf4j.Slf4j;
import my.project.msa.orderservice.dto.OrderDto;
import my.project.msa.orderservice.entity.OrderEntity;
import my.project.msa.orderservice.mapper.OrderServiceMapper;
import my.project.msa.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    private final OrderServiceMapper mapper = OrderServiceMapper.INSTANCE;
    private final OrderRepository repository;


    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderDto createdOrder(OrderDto orderDetails) {

        orderDetails.setOrderId(UUID.randomUUID().toString());
        orderDetails.setTotalPrice(orderDetails.getUnitPrice() * orderDetails.getQty());
        OrderEntity orderEntity = mapper.toOrderEntity(orderDetails);
        repository.save(orderEntity);
        OrderEntity byOrderId = repository.findByOrderId(orderDetails.getOrderId());
        System.out.println("byOrderId = " + byOrderId);
        return mapper.toOrderDto(repository.findByOrderId(orderDetails.getOrderId()));
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {

        OrderEntity orderEntity = repository.findByOrderId(orderId);
        OrderDto orderDto = mapper.toOrderDto(orderEntity);
        return orderDto;
    }

    @Override
    public Iterable<OrderEntity> getOrdersByUserId(String userId) {
        return repository.findByUserId(userId);
    }
}
