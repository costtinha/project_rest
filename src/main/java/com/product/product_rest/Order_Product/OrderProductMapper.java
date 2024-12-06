package com.product.product_rest.Order_Product;
import com.product.product_rest.Order.Order;
import com.product.product_rest.Product.Product;
import org.springframework.stereotype.Service;

@Service
public class OrderProductMapper {
    public Order_Product toOrderProduct(OrderProductDto dto){
        OrderProductKey key = new OrderProductKey();
        Order order = new Order();
        order.setOrderId(dto.orderId());
        Product product = new Product();
        product.setCode(dto.productId());
        key.setOrderId(dto.orderId());
        key.setProductCode(dto.productId());
        return new Order_Product(key,order,product,dto.qty(),dto.priceEach());

    }

    public OrderProductResponseDto toOrderProductResponseDto(Order_Product op){
        return new OrderProductResponseDto(op.getOrderId().getOrderId(),
                op.getProductId().getCode(),
                op.getQty(),
                op.getPriceEach());
    }
}
