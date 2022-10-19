package com.jpa_product.repository;

import com.jpa_product.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    Product findById(int id);

    void delete(int id);

    public List<Product> findByName(String name);

}
