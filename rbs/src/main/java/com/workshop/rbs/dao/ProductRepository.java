package com.workshop.rbs.dao;

import com.workshop.rbs.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product, Long> {


    // find a product by name
    public Page<Product> findByNameContains(String mc, Pageable pageable);

    // find with some specification
    @Query("select p from Product p where p.name like :x and p.price>:y")
    public  Page<Product> findThis(
            @Param("x")String mc,
            @Param("y")double minPrice,
            Pageable pageable
    );
}
