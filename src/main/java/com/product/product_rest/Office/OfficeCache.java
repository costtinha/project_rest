package com.product.product_rest.Office;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash(value = "Office", timeToLive = 3600)
public class OfficeCache implements Serializable {
    @Id
    private int Code;
    private String City;
    private String Phone;
    private String Address1;
    private String Address2;
    private String State;
    private String Country;
    private int PostalCode;
    private String Territory;

    private List<Integer> employeesId;

    public OfficeCache(String city,
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

    public OfficeCache() {
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

    public List<Integer> getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(List<Integer> employeesId) {
        this.employeesId = employeesId;
    }
}
