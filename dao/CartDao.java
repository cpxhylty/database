package dao;

import pojo.CartItem;

import java.util.List;

public interface CartDao {
    void addIntoCart(String account, String dishName, int dishNumber);

    void deleteFromCart(String account, String dishName, int dishNumber);

    void deleteByAccount(String account);

    List<CartItem> getAll(String account);

    float countPrice(String account);
}
