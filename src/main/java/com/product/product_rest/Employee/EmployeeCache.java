package com.product.product_rest.Employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.product.product_rest.Customer.Customer;
import com.product.product_rest.Office.Office;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash(value = "Employee", timeToLive = 3600)
public class EmployeeCache {
    @Id
    private int employeeId;
    private Office OfficeCode;
    private int reportsTo;
    private String LastName;
    private String FirstName;
    private String Extension;
    private String Email;
    private String JobTitle;

    private List<Integer> employeesId;

    private List<Integer> customersId;

    public EmployeeCache(Office OfficeCode, int reportsTo, String lastName, String firstName, String extension, String email, String jobTitle) {
        this.OfficeCode = OfficeCode;
        this.reportsTo = reportsTo;
        LastName = lastName;
        FirstName = firstName;
        Extension = extension;
        Email = email;
        JobTitle = jobTitle;
    }

    public EmployeeCache() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(int reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getExtension() {
        return Extension;
    }

    public void setExtension(String extension) {
        Extension = extension;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public List<Integer> getEmployees() {
        return employeesId;
    }

    public void setEmployees(List<Integer> employees) {
        this.employeesId = employees;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public List<Integer> getCustomers() {
        return customersId;
    }

    public void setCustomers(List<Integer> customers) {
        this.customersId = customers;
    }

    public Office getOfficeCode() {
        return OfficeCode;
    }

    public void setOfficeCode(Office officeCode) {
        OfficeCode = officeCode;
    }
}
