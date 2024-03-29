package com.geekbrains.artur.springMarket.controller;

import com.geekbrains.artur.springMarket.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){this.productService = productService;}

    @GetMapping("{id}")
    public String productPage(Model model, @PathVariable("id") Long id){
        logger.info("Product {} page", id);
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("products", productService.findAll());

        return "product";
    }
}
