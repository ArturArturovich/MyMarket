package com.geekbrains.artur.springMarket.persist.model.repo;

import com.geekbrains.artur.springMarket.persist.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
