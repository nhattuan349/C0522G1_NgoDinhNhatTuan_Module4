package com.jpa_product.repository;

import com.jpa_product.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class ProductRepositoryImpl implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager
                .createQuery("select s from Product as s", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }


    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = entityManager
                .createQuery("select  p from Product as p" + " where p.id=:id",Product.class).setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p where p.name like :name" , Product.class );
        query.setParameter("name","%"+name+"%");
        return query.getResultList();
    }
}
