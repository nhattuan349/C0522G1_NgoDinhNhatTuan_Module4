package com.product.service;

import com.product.model.Product;
import com.product.repository.IProductReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductReposistory productReposistory;

    @Override
    public List<Product> findAll() {
        return productReposistory.findAll();
    }

    @Override
    public void save(Product product) {
        productReposistory.save(product);
    }

    @Override
    public Product findByID(int id) {
        return productReposistory.findByID(id);
    }

    @Override
    public void update(int id, Product product) {
        productReposistory.update(id, product);
    }

    @Override
    public void remove(int id) {
        productReposistory.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productReposistory.findByName(name);
    }
}
