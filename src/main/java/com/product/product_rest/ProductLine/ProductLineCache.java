package com.product.product_rest.ProductLine;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash(value = "ProductLine", timeToLive = 3600)
public class ProductLineCache {

    @Id
    private int id;
    private String descInText;
    private String descInHTML;
    private String Image;
    private List<Integer> productsCode;

    public ProductLineCache(String descInText, String descInHTML, String image) {
        this.descInText = descInText;
        this.descInHTML = descInHTML;
        Image = image;
    }

    public ProductLineCache() {
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

    public List<Integer> getProductsCode() {
        return productsCode;
    }

    public void setProductsCode(List<Integer> productsCode) {
        this.productsCode = productsCode;
    }
}
