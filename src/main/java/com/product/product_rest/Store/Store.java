package com.product.product_rest.Store;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.product.product_rest.Order.Order;
import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Store.findStoreByName", query = "SELECT s FROM Store s WHERE s.StoreName = :StoreName")
        }
)
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
