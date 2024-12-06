package com.product.product_rest.Store;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.product.product_rest.Order.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Store {
    @Id
    @GeneratedValue
    private int StoreId;
    private String StoreName;

    @OneToMany(mappedBy = "StoreId")
    @JsonManagedReference
    private List<Order> orders;

    public Store(String storeName) {
        StoreName = storeName;
    }

    public Store() {
    }

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int storeId) {
        StoreId = storeId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }
}
