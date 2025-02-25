package com.product.product_rest.ProductLine;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.product.product_rest.Product.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries(
        {
                @NamedQuery(name ="ProductLine.findProductLineByImage", query = "SELECT p FROM ProductLine p WHERE p.Image = :image")
        }
)
public class ProductLine {

    @Id
    @GeneratedValue
    private int id;
    private String descInText;
    private String descInHTML;
    @Column(
            length = 100
    )
    private String Image;
    @OneToMany(mappedBy = "productLine_id")
    @JsonManagedReference
    private List<Product> products;

    public ProductLine(String descInText, String descInHTML, String image) {
        this.descInText = descInText;
        this.descInHTML = descInHTML;
        Image = image;
    }

    public ProductLine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescInText() {
        return descInText;
    }

    public void setDescInText(String descInText) {
        this.descInText = descInText;
    }

    public String getDescInHTML() {
        return descInHTML;
    }

    public void setDescInHTML(String descInHTML) {
        this.descInHTML = descInHTML;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
