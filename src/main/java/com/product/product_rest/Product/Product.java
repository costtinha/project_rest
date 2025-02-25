package com.product.product_rest.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.product.product_rest.Order_Product.Order_Product;
import com.product.product_rest.ProductLine.ProductLine;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NamedQueries(
        {
                @NamedQuery(name="Product.findProductByVendor ", query = "SELECT p FROM Product p  WHERE p.vendor = :vendor")
        }
)
public class Product {
    @Id
    @GeneratedValue
    private int Code;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "id"
    )
    private ProductLine productLine_id;
    private String Name;
    private String vendor;
    private  String pdtDescription;
    private int QntyInStock;
    @Column(
            precision = 19,
            scale = 0
    )
    private BigDecimal BuyPrice;
    private String MSRP;

    @OneToMany(mappedBy = "ProductId")
    @JsonManagedReference
    private List<Order_Product> order_products;



    public Product(ProductLine productLine_id, String name, String vendor, String pdtDescription, int qntyInStock, BigDecimal buyPrice, String MSRP) {
        this.productLine_id = productLine_id;
        Name = name;
        this.vendor = vendor;
        this.pdtDescription = pdtDescription;
        QntyInStock = qntyInStock;
        BuyPrice = buyPrice;
        this.MSRP = MSRP;
    }

    public Product() {
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public ProductLine getProductLine_id() {
        return productLine_id;
    }

    public void setProductLine_id(ProductLine productLine_id) {
        this.productLine_id = productLine_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPdtDescription() {
        return pdtDescription;
    }

    public void setPdtDescription(String pdtDescription) {
        this.pdtDescription = pdtDescription;
    }

    public BigDecimal getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        BuyPrice = buyPrice;
    }

    public int getQntyInStock() {
        return QntyInStock;
    }

    public void setQntyInStock(int qntyInStock) {
        QntyInStock = qntyInStock;
    }

    public String getMSRP() {
        return MSRP;
    }

    public void setMSRP(String MSRP) {
        this.MSRP = MSRP;
    }

    public List<Order_Product> getOrder_products() {
        return order_products;
    }

    public void setOrder_products(List<Order_Product> order_products) {
        this.order_products = order_products;
    }
}
