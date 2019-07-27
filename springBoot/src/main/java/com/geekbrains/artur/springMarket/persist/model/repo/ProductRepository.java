package com.geekbrains.artur.springMarket.persist.model.repo;

import com.geekbrains.artur.springMarket.persist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
