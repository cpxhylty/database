package servlet;

import pojo.DishComment;
import pojo.Menu;
import service.DishService;
import service.impl.DishServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DishServlet extends HttpServlet {
    DishService dishService = new DishServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("get menu")) {

            Menu menu = dishService.getAllDish();

            HttpSession session = req.getSession();
            session.setAttribute("menu", menu);

            resp.sendRedirect("");
        }
    }
}
