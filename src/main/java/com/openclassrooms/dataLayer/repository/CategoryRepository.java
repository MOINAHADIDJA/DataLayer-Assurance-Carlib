package com.openclassrooms.dataLayer.repository;

import com.openclassrooms.dataLayer.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    public Iterable<Category> findByName(String name);

    public Iterable<Category> findByProductsName(String name);
}
