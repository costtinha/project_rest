    package com.product.product_rest.Customer;

    import com.fasterxml.jackson.annotation.JsonBackReference;
    import com.fasterxml.jackson.annotation.JsonManagedReference;
    import com.product.product_rest.Employee.Employee;
    import com.product.product_rest.Order.Order;
    import com.product.product_rest.Payment.Payment;
    import jakarta.persistence.*;

    import java.math.BigDecimal;
    import java.util.List;

    @Entity
    @NamedQueries(
            {
                    @NamedQuery(name = "Customer.findCustomerByName", query = "SELECT c FROM Customer c WHERE c.FirstName = :firstName AND c.LastName = :lastName"),
                    @NamedQuery(name = "Customer.findCustomerByState", query = "SELECT c FROM Customer c WHERE c.State = :state"),
                    @NamedQuery(name = "Customer.findCustomerByCity", query = "SELECT c FROM Customer c WHERE c.City = :city" )
            }
    )
    public class Customer {
        @Id
        @GeneratedValue
        private int Id;

        @ManyToOne
        @JsonBackReference
        @JoinColumn(name = "employeeId")
        private Employee SalesRepEmployeeNum;

        private String LastName;
        private String FirstName;
        private String Phone;
        private String Address1;
        private String Address2;
        private String City;
        private String State;
        private int PostalCode;
        private String Country;
        @Column(precision = 19, scale = 0)
        private BigDecimal CreditLimit;

        @OneToMany(mappedBy = "CustomerId")
        @JsonManagedReference
        private List<Payment> payments;


        @OneToMany(mappedBy = "CustomerId")
        @JsonManagedReference
        private List<Order> orders;


        public Customer(Employee salesRepEmployeeNum, String lastName,
                        String firstName, String phone, String address1,
                        String address2, String city, String state,
                        int postalCode, String country, BigDecimal creditLimit) {
            SalesRepEmployeeNum = salesRepEmployeeNum;
            LastName = lastName;
            FirstName = firstName;
            Phone = phone;
            Address1 = address1;
            Address2 = address2;
            City = city;
            State = state;
            PostalCode = postalCode;
            Country = country;
            CreditLimit = creditLimit;
        }

        public Customer() {
        }


        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public Employee getSalesRepEmployeeNum() {
            return SalesRepEmployeeNum;
        }

        public void setSalesRepEmployeeNum(Employee salesRepEmployeeNum) {
            SalesRepEmployeeNum = salesRepEmployeeNum;
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

        public String getAddress2() {
            return Address2;
        }

        public void setAddress2(String address2) {
            Address2 = address2;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String city) {
            City = city;
        }

        public String getState() {
            return State;
        }

        public void setState(String state) {
            State = state;
        }

        public int getPostalCode() {
            return PostalCode;
        }

        public void setPostalCode(int postalCode) {
            PostalCode = postalCode;
        }

        public String getCountry() {
            return Country;
        }

        public void setCountry(String country) {
            Country = country;
        }

        public BigDecimal getCreditLimit() {
            return CreditLimit;
        }

        public void setCreditLimit(BigDecimal creditLimit) {
            CreditLimit = creditLimit;
        }

        public List<Payment> getPayments() {
            return payments;
        }

        public void setPayments(List<Payment> payments) {
            this.payments = payments;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }
    }
