package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface IProductReposistory {
    List<Product> findAll();
    void save(Product product);
    Product findByID(int id);
    void update(int id, Product product);
    void remove(int id);
    public List<Product> findByName(String name);

}
