package com.openclassrooms.dataLayer.service;

import com.openclassrooms.dataLayer.model.Category;
import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/***
 "Created by Moinahadidja Mohamed Chakir on "15/10/2022
 */

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id).get();
    }

    public Iterable<Category> getCategoryByName(String name){
        return categoryRepository.findByName(name);
    }
    public Iterable<Category> getCategoriesByProductName(String name){
        return categoryRepository.findByProductsName(name);
    }

    public Category saveCategory(Category c){
        return categoryRepository.save(c);
    }
    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }
}
