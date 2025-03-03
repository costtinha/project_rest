package com.product.product_rest.Order_Product;

import com.product.product_rest.Persistance.OrderProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderProductService {
    private final OrderProductRepository repository;
    private final OrderProductMapper mapper;

    public OrderProductService(OrderProductRepository repository,
                               OrderProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<OrderProductResponseDto> findOrderProduct(){
        return repository.findAll()
                .stream()
                .map(mapper::toOrderProductResponseDto)
                .collect(Collectors.toList());
    }

    public OrderProductResponseDto saveOrderProduct(OrderProductDto dto){
        return mapper.toOrderProductResponseDto(repository.save(mapper.toOrderProduct(dto)));
    }

    public OrderProductResponseDto findOrderProductById(int orderId, int productCode){
        OrderProductKey key = new OrderProductKey(orderId,productCode);
        Order_Product orderProduct = repository.findById(key).orElse(null);
        return mapper.toOrderProductResponseDto(orderProduct);

    }

    public List<Order_Product> findOrderProductTotal(){
        return repository.findAll();
    }

    public void deleteOrderProductById(int orderId, int productCode){
        OrderProductKey key = new OrderProductKey(orderId,productCode);
        repository.deleteById(key);
    }


}
