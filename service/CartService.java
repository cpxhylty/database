package service;

import pojo.CartItem;

import java.util.List;

public interface CartService {
    void addIntoCart(String account, String dishName, int dishNumber);

    void deleteFromCart(String account, String dishName, int dishNumber);

    void deleteByAccount(String account);

    List<CartItem> getAll(String account);

    float countPrice(String account);
}
