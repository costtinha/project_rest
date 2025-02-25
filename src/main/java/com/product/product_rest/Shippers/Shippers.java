package com.product.product_rest.Shippers;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.product.product_rest.Order.Order;
import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Shippers.findShippersByCompanyName", query = "SELECT s FROM Shippers s WHERE s.companyName = :companyName")
})
public class Shippers {
    @Id
    @GeneratedValue
    private int ShipId;
    private String companyName;
    private String phoneNumber;

    @OneToMany(mappedBy = "ShippingId")
    @JsonManagedReference
    private List<Order> orders;


    public Shippers(String companyName, String phoneNumber) {
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
    }

    public Shippers() {
    }

    public int getShipId() {
        return ShipId;
    }

    public void setShipId(int shipId) {
        ShipId = shipId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
