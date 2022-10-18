package com.product.repository;

import com.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductReposistoryImpl implements IProductReposistory{


    private static Map<Integer,Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Curtiss Warhawk 2018", 105000, 35, "động cơ V-twin, dung tích 2.163cc"));
        products.put(2, new Product(2, "Flathead của Olson Auto", 200000, 50, "động cơ Flathead V8 của Ford"));
        products.put(3, new Product(3, "Dodge Tomahawk", 555000, 10, "động cơ V10 8,3 lít, kết cấu 4 bánh"));
        products.put(4, new Product(4, "Van Veen OCR1000", 105000, 38, "107 mã lực"));
        products.put(5, new Product(5, "Track T800-CDi", 50000, 100, "khung gầm của KTM 900 Adventure"));
        products.put(6, new Product(6, "Dark Side", 300000, 1, " Bandit9 Dark Side hoàn hảo tới từng chi tiết"));
        products.put(7, new Product(7, "Yamaha V-Max", 115000, 1, "Chiếc xe được đưa về Việt Nam "));
    }



    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());

    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findByID(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        for (Product product : products.values())
            if (product.getName().contains(name)) {
                list.add(product);
            }
        return list;
    }
}
