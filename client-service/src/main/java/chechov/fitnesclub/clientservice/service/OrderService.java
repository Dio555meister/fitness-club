package chechov.fitnesclub.clientservice.service;

import chechov.fitnesclub.clientservice.dto.OrderDto;
import chechov.fitnesclub.clientservice.entity.Client;
import chechov.fitnesclub.clientservice.entity.Order;
import chechov.fitnesclub.clientservice.mapper.OrderMapper;
import chechov.fitnesclub.clientservice.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Transactional
    public UUID createClientBuy(OrderDto orderDto) {
        Order save = orderRepository.save(orderMapper.toEntity(orderDto));
        log.info("Покупка с id{} успешно создана", orderDto);
        return save.getId();
    }

    @Transactional(readOnly = true)
    public OrderDto getClientBuy(UUID id) {
        Order order = getClientBuyOrThrow(id);
        log.info("Покупка с id{} успешно получена", id);
        return orderMapper.toDto(order);
    }

    @Transactional(readOnly = true)
    public List<OrderDto> getAllClientBuy() {
        List<Order> all = orderRepository.findAll();
        log.info("Получен список всех покупок");
        return all.stream().map(orderMapper::toDto)
                .toList();
    }

    @Transactional
    public OrderDto updateClientBuy(UUID id, OrderDto orderDto) {
        Order order = getClientBuyOrThrow(id);
        log.info("Клиентская покупка с id{} успешно получена ", id);
        order.setClient(Client.builder().id(orderDto.getClientId()).build());
        order.setPaymentId(orderDto.getPaymentId());
        order.setAmount(orderDto.getAmount());
        order.setDate(orderDto.getDate());

        return orderMapper.toDto(order);
    }

    @Transactional
    public void deleteClientBuy(UUID id) {
        orderRepository.deleteById(id);
        log.info("Клиент с id {} был удален", id);
    }

    private Order getClientBuyOrThrow(UUID id) {
        return orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
