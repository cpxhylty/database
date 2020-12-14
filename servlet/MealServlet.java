package servlet;

import pojo.Meal;
import service.MealService;
import service.impl.MealServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MealServlet extends HttpServlet {
    MealService mealService = new MealServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("get all")) {
            List<Meal> meals = mealService.getAllMeal();
            HttpSession session = req.getSession();
            session.setAttribute("meals",meals);
            resp.sendRedirect("/db_war_exploded/staff/waiter-admin-list.jsp");
        }
    }
}
