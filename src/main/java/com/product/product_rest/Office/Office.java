package com.product.product_rest.Office;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.product.product_rest.Employee.Employee;
import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Office.findOfficeByCity", query = "SELECT o FROM Office o WHERE o.City = :city"),
        @NamedQuery(name = "Office.findOfficeByState", query = "SELECT o FROM Office o WHERE o.State = :state"),
        @NamedQuery(name = "Office.findOfficeByCountry", query = "SELECT o FROM Office o WHERE o.Country = :country")
})
public class Office {
    @Id
    @GeneratedValue
    private int Code;
    private String City;
    private String Phone;
    private String Address1;
    private String Address2;
    private String State;
    private String Country;
    private int PostalCode;
    @Column(
            length = 100
    )
    private String Territory;
    @OneToMany(mappedBy = "OfficeCode")
    @JsonManagedReference
    private List<Employee> employees;

    public Office(String city,
                  String phone,
                  String address1,
                  String address2, String state,
                  String country,
                  int postalCode, String territory) {
        City = city;
        Phone = phone;
        Address1 = address1;
        Address2 = address2;
        State = state;
        Country = country;
        PostalCode = postalCode;
        Territory = territory;
    }

    public Office() {
    }


    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(int postalCode) {
        PostalCode = postalCode;
    }

    public String getTerritory() {
        return Territory;
    }

    public void setTerritory(String territory) {
        Territory = territory;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
