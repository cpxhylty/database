package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import pojo.CartItem;
import service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();

    @Override
    public void addIntoCart(String account, String dishName, int dishNumber) {
        cartDao.addIntoCart(account, dishName, dishNumber);
    }

    @Override
    public void deleteFromCart(String account, String dishName, int dishNumber) {
        cartDao.deleteFromCart(account, dishName, dishNumber);
    }

    @Override
    public void deleteByAccount(String account) {
        cartDao.deleteByAccount(account);
    }

    @Override
    public List<CartItem> getAll(String account) {
        return cartDao.getAll(account);
    }

    @Override
    public float countPrice(String account) {
        return cartDao.countPrice(account);
    }
}
