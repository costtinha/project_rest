package com.product.product_rest.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.product.product_rest.Customer.Customer;
import com.product.product_rest.Order_Product.Order_Product;
import com.product.product_rest.Shippers.Shippers;
import com.product.product_rest.Store.Store;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue
    private int OrderId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "Id"
    )
    private Customer CustomerId;
    private LocalDateTime OrderDate;
    private LocalDateTime RequiredDate;
    private LocalDateTime ShippedDate;
    private int Status;
    private String Coments;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "ShipId"
    )
    private Shippers ShippingId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "StoreId;"
    )
    private Store StoreId;

    @OneToMany(mappedBy = "OrderId")
    @JsonManagedReference
    private List<Order_Product> order_products;

    public Order(Customer customerId, LocalDateTime orderDate,
                 LocalDateTime requiredDate,
                 LocalDateTime shippedDate,
                 int status, String coments,
                 Shippers shipId, Store storeId) {
        CustomerId = customerId;
        OrderDate = orderDate;
        RequiredDate = requiredDate;
        ShippedDate = shippedDate;
        Status = status;
        Coments = coments;
        ShippingId = shipId;
        StoreId = storeId;
    }


    public Order() {
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public Customer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Customer customerId) {
        CustomerId = customerId;
    }

    public LocalDateTime getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        OrderDate = orderDate;
    }

    public LocalDateTime getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(LocalDateTime requiredDate) {
        RequiredDate = requiredDate;
    }

    public LocalDateTime getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(LocalDateTime shippedDate) {
        ShippedDate = shippedDate;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getComents() {
        return Coments;
    }

    public void setComents(String coments) {
        Coments = coments;
    }

    public Shippers getShippingId() {
        return ShippingId;
    }

    public void setShippingId(Shippers shipId) {
        ShippingId = shipId;
    }

    public Store getStoreId() {
        return StoreId;
    }

    public void setStoreId(Store storeId) {
        StoreId = storeId;
    }

    public List<Order_Product> getOrder_products() {
        return order_products;
    }

    public void setOrder_products(List<Order_Product> order_products) {
        this.order_products = order_products;
    }
}
