package com.openclassrooms.dataLayer.service;

import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/***
 "Created by Moinahadidja Mohamed Chakir on "15/10/2022
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).get();
    }

    public Product saveProduct(Product p){
        return productRepository.save(p);
    }

    public Iterable<Product> getProductByName(String name){
        return productRepository.findByName(name);
    }

    public Iterable<Product> getProductByCategoryName(String name){
        return productRepository.findByCategoriesName(name);
    }
    public void deleteProductById(int id){
        productRepository.deleteById(id);
    }

    public Iterable<Product> getProductsByCostLessThan(int cost){
        return productRepository.findByCostLessThan(cost);
    }

}
