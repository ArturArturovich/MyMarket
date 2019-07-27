package com.geekbrains.artur.springMarket.service;

import com.geekbrains.artur.springMarket.service.model.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CartServiceImpl implements CartService {

    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private Map<ProductInfo, Integer> cartItems;

    public CartServiceImpl() {
        cartItems = new ConcurrentHashMap<>();
    }


    @Override
    public void addItemQty(ProductInfo productInfo, int qty) {
        cartItems.put(productInfo, cartItems.getOrDefault(productInfo, 0) + qty);
    }

    @Override
    public void removeItemQty(ProductInfo productInfo, int qty) {
        int currentQty = cartItems.getOrDefault(productInfo, 0);
        if (currentQty - qty > 0){
            cartItems.put(productInfo, currentQty - qty);
        } else {
            cartItems.remove(productInfo);
        }

    }

    @Override
    public void removeItem(ProductInfo productInfo) {cartItems.remove(productInfo);}


    @Override
    public Map<ProductInfo, Integer> findAllItems() {
        return Collections.unmodifiableMap(cartItems);
    }

    @Override
    public Integer getItemQty() { return cartItems.size(); }

    @Override
    public BigDecimal getSubTotal() {
        return cartItems.entrySet().stream()
                .map(e -> e.getKey().getProduct().getPrice().multiply(new BigDecimal(e.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private long created;

    @PostConstruct
    public void postConstruct(){
        created = System.currentTimeMillis();
        logger.info("Session bean created");
        }

        @PreDestroy
    public void preDestroy(){ logger.info("Session bean destroyed {}", (System.currentTimeMillis() - created));}
}
