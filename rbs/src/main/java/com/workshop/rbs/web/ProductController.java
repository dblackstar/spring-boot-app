package com.workshop.rbs.web;


import com.workshop.rbs.dao.ProductRepository;
import com.workshop.rbs.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    // dao
    @Autowired
    private ProductRepository productRepository;

    // home page
    @GetMapping(path = "/")
    public String index(){
        return "index";
    }

    // get all products
    @GetMapping(path = "/products")
    public String products(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("listproducts", products);
        return "products";
    }



}
