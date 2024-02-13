package my.project.msa.orderservice.controller;

import lombok.extern.slf4j.Slf4j;
import my.project.msa.orderservice.dto.OrderDto;
import my.project.msa.orderservice.dto.request.RequestOrder;
import my.project.msa.orderservice.dto.response.ResponseObject;
import my.project.msa.orderservice.dto.response.ResponseOrder;
import my.project.msa.orderservice.entity.OrderEntity;
import my.project.msa.orderservice.mapper.OrderServiceMapper;
import my.project.msa.orderservice.service.OrderService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order-service")
public class OrderController {
    Environment env;
    OrderService orderService;
    OrderServiceMapper mapper = OrderServiceMapper.INSTANCE;

    public OrderController(Environment env, OrderService orderService) {
        this.env = env;
        this.orderService = orderService;
    }

    @GetMapping("health_check")
    public String status(){
        return String.format("It's Working in Order Service on PORT %s", env.getProperty("local.server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@PathVariable String userId,
                                                     @RequestBody RequestOrder orderDetails){
        System.out.println("orderDetails = " + orderDetails);
        OrderDto orderDto = mapper.toOrderDto(orderDetails);
        orderDto.setUserId(userId);
        OrderDto createdOrder = orderService.createdOrder(orderDto);
        System.out.println("createdOrder = " + createdOrder);
        ResponseOrder responseOrder = mapper.toResponseOrder(createdOrder);

        System.out.println("responseOrder = " + responseOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrder);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<ResponseObject> getOrder(@PathVariable String userId){
        Iterable<OrderEntity> orderList = orderService.getOrdersByUserId(userId);

        List<ResponseOrder> result = new ArrayList<>();
        orderList.forEach(v-> {
            result.add(mapper.toResponseOrder(v));
        });
        ResponseObject responseObject = new ResponseObject(result, result.size());
        return ResponseEntity.ok(responseObject);
    }
}
