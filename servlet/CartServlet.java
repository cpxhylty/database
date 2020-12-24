package servlet;

import pojo.CartItem;
import service.CartService;
import service.impl.CartServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CartServlet extends HttpServlet {
    CartService cartService = new CartServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("add")) {
            String account = req.getParameter("account");
            String dishName = req.getParameter("name");
            int number = Integer.parseInt(req.getParameter("number"));

            cartService.addIntoCart(account, dishName, number);

            resp.sendRedirect("");
        }
        else if (operation.equals("delete")) {
            String account = req.getParameter("account");
            String dishName = req.getParameter("name");
            int number = Integer.parseInt(req.getParameter("number"));

            cartService.deleteFromCart(account, dishName, number);

            resp.sendRedirect("");
        }
        else if (operation.equals("get all")) {
            String account = req.getParameter("account");

            List<CartItem> cart = cartService.getAll(account);
            float price = cartService.countPrice(account);

            HttpSession session = req.getSession();
            session.setAttribute("cart", cart);
            session.setAttribute("price", price);

            resp.sendRedirect("");
        }
    }
}
