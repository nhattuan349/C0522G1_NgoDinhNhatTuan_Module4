package com.complete_the_shopping_cart.dto;

import javax.persistence.Column;
import java.util.Objects;

public class ProductDto {
    private Integer id;
    private String name;
    private  String image;
    private long price;
    private int productCode;
    private String description;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, String image, long price, int productCode, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.productCode = productCode;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
