package com.product.product_rest.Order;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;

    public OrderService(OrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<OrderResponseDto> findOrder(){
        return repository.findAll()
                .stream()
                .map(mapper::toOrderResponseDto)
                .collect(Collectors.toList());
    }

    public OrderResponseDto saveOrder(OrderDto dto){
        return mapper.toOrderResponseDto(repository.save(mapper.toOrder(dto)));
    }

    public OrderResponseDto findOrderById(int id){
        return mapper.toOrderResponseDto(repository.findById(id).orElse(null));
    }

    public List<Order> findOrderTotal(){
        return repository.findAll();
    }

    public void deleteOrderById(int id){
        repository.deleteById(id);
    }

    public List<OrderResponseDto> findOrderByStatus(int status) {
        return repository.findOrderByStatus(status)
                .stream()
                .map(mapper::toOrderResponseDto)
                .collect(Collectors.toList());
    }
}
