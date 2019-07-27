package com.geekbrains.artur.springMarket.persist.model.repo;

import com.geekbrains.artur.springMarket.persist.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
