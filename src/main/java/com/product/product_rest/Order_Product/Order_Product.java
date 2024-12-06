package com.product.product_rest.Order_Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.product.product_rest.Order.Order;
import com.product.product_rest.Product.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Order_Product {
    @EmbeddedId
    private OrderProductKey id  ;

    @ManyToOne
    @MapsId("orderId")
    @JsonBackReference
    @JoinColumn(
            name = "Id"
    )
    private Order OrderId;

    @ManyToOne
    @MapsId("productCode")
    @JsonBackReference
    @JoinColumn(
            name = "Code"
    )
    private Product ProductId;

    private int Qty;

    @Column(
            precision = 19,
            scale = 0
    )
    private BigDecimal PriceEach;

    public Order_Product(OrderProductKey id,
                         Order orderId,
                         Product productId,
                         int qty,
                         BigDecimal priceEach) {
        this.id = id;
        OrderId = orderId;
        ProductId = productId;
        Qty = qty;
        PriceEach = priceEach;
    }

    public Order_Product() {
    }

    public OrderProductKey getId() {
        return id;
    }

    public void setId(OrderProductKey id) {
        this.id = id;
    }

    public Order getOrderId() {
        return OrderId;
    }

    public void setOrderId(Order orderId) {
        OrderId = orderId;
    }

    public Product getProductId() {
        return ProductId;
    }

    public void setProductId(Product productId) {
        ProductId = productId;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public BigDecimal getPriceEach() {
        return PriceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        PriceEach = priceEach;
    }
}
