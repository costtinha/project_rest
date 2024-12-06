package com.product.product_rest.Order;

import com.product.product_rest.Customer.Customer;
import com.product.product_rest.Shippers.Shippers;
import com.product.product_rest.Store.Store;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderDto dto){
        Customer customer = new Customer();
        customer.setId(dto.customerId());
        Shippers shippers = new Shippers();
        shippers.setShipId(dto.shipId());
        Store store = new Store();
        store.setStoreId(dto.storeId());
        return new Order(customer,dto.orderDate(),
                dto.requiredDate(),
                dto.shippedDate(),
                dto.status(),
                dto.coments(),
                shippers,store);

    }

    public OrderResponseDto toOrderResponseDto(Order order){
        return new OrderResponseDto(order.getCustomerId().getId(),
                order.getOrderDate(),
                order.getRequiredDate());
    }
}
