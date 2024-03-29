package com.geekbrains.artur.springMarket.service;

import com.geekbrains.artur.springMarket.controller.repr.ProductRepr;
import com.geekbrains.artur.springMarket.persist.model.Picture;
import com.geekbrains.artur.springMarket.persist.model.PictureData;
import com.geekbrains.artur.springMarket.persist.model.Product;
import com.geekbrains.artur.springMarket.persist.model.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){this.productRepository = productRepository;}


    @Override
    @Transactional
    public List<ProductRepr> findAll() {
        return productRepository.findAll().stream()
                .map(ProductRepr::new)
                .collect(Collectors.toList());
    }



    @Override
    @Transactional
    public ProductRepr findById(Long id) {
        return new ProductRepr(productRepository.findById(id).get());
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void save(ProductRepr productRepr) throws IOException {
        Product product = (productRepr.getId() != null) ? productRepository.findById(productRepr.getId()).get()
                : new Product();
        product.setName(productRepr.getName());
        product.setCategories(productRepr.getCategories());
        product.setBrand(productRepr.getBrand());
        product.setPrice(productRepr.getPrice());
        if (productRepr.getNewPictures() != null) {
            for (MultipartFile newPicture : productRepr.getNewPictures()) {
                logger.info("Product {} file {} size {}", product.getId(),
                        newPicture.getOriginalFilename(), newPicture.getSize());

                if (product.getPictures() == null) {
                    product.setPictures(new ArrayList<>());
                }

                product.getPictures().add(new Picture(newPicture.getOriginalFilename(),
                        newPicture.getContentType(), new PictureData(newPicture.getBytes())));
            }
        }
        productRepository.save(product);
    }
}
