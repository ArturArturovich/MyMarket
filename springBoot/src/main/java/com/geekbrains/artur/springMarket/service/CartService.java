package com.geekbrains.artur.springMarket.service;

import com.geekbrains.artur.springMarket.service.model.ProductInfo;

import java.math.BigDecimal;
import java.util.Map;

public interface CartService {

    void addItemQty(ProductInfo productInfo, int qty);

    void removeItemQty(ProductInfo productInfo, int qty);

    void removeItem(ProductInfo productInfo);

    Map<ProductInfo, Integer> findAllItems();

    Integer getItemQty();

    BigDecimal getSubTotal();
}
