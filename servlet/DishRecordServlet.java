package servlet;

import service.DishRecordService;
import service.impl.DishRecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DishRecordServlet extends HttpServlet {
    DishRecordService dishRecordService = new DishRecordServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("order")) {
            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
            String dishName = req.getParameter("dishName");
            int dishNumber = Integer.parseInt(req.getParameter("dishNumber"));

            dishRecordService.orderDish(orderNumber, dishName, dishNumber);

            resp.sendRedirect("");
        }
        else if (operation.equals("delete")) {
            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
            String dishName = req.getParameter("dishName");
            int deleteNumber = Integer.parseInt(req.getParameter("deleteNumber"));

            dishRecordService.deleteDish(orderNumber, dishName, deleteNumber);

            resp.sendRedirect("");
        }
    }
}
