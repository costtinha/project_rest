package com.product.product_rest.Employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.product.product_rest.Customer.Customer;
import com.product.product_rest.Office.Office;
import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findEmployeeByJobTitle", query = "SELECT e FROM Employee e WHERE e.JobTitle = :JobTitle"),
        @NamedQuery(name = "Employee.findEmployeeByEmail", query = "SELECT e FROM Employee e WHERE e.Email = :email")
})
public class Employee {
    @Id
    @GeneratedValue
    private int employeeId;


    @ManyToOne
    @JsonBackReference
    @JoinColumn( name = "Code")
    private Office OfficeCode;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "reports_to_id")
    private Employee reportsTo;

    private String LastName;
    private String FirstName;
    private String Extension;
    private String Email;
    @Column(
            length = 100
    )
    private String JobTitle;

    @OneToMany(mappedBy = "reportsTo")
    @JsonManagedReference
    private List<Employee> employees;

    @OneToMany(mappedBy = "SalesRepEmployeeNum")
    @JsonManagedReference
    private List<Customer> customers;

    public Employee(Office OfficeCode, Employee reportsTo, String lastName, String firstName, String extension, String email, String jobTitle) {
        this.OfficeCode = OfficeCode;
        this.reportsTo = reportsTo;
        LastName = lastName;
        FirstName = firstName;
        Extension = extension;
        Email = email;
        JobTitle = jobTitle;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Office getOfficeCode() {
        return OfficeCode;
    }

    public void setOfficeCode(Office officeCode) {
        OfficeCode = officeCode;
    }
}
