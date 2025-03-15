package chechov.fitnesclub.clientservice.controller;

import chechov.fitnesclub.clientservice.dto.OrderDto;
import chechov.fitnesclub.clientservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController  {
    private final OrderService orderService;

    @PostMapping
    public UUID createOrder(OrderDto orderDto) {
        log.info("Пришел запрос на создание заказа с id{}", orderDto);
        return orderService.createClientBuy(orderDto);
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable UUID id) {
        log.info("Пришел запрос на получение заказа с id{}", id);
        return orderService.getClientBuy(id);
    }

    @GetMapping
    public List<OrderDto> getOrders() {
        log.info("Пришел запрос на получение списка всех заказов");
        return orderService.getAllClientBuy();
    }

    @PutMapping("/{id}")
    public OrderDto updateOrder(@PathVariable UUID id, @RequestBody OrderDto orderDto) {
        log.info("Пришел запрос на обновление заказа");
        return orderService.updateClientBuy(id, orderDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable UUID id) {
        log.info("Пришел запрос на удаление заказа");
        orderService.deleteClientBuy(id);
    }
}
