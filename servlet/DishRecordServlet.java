package servlet;

import pojo.DishRecord;
import service.DishRecordService;
import service.impl.DishRecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
        else if (operation.equals("search")) {
            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));

            List<DishRecord> dishRecords = dishRecordService.searchByOrderNumber(orderNumber);

            HttpSession session = req.getSession();
            session.setAttribute("dishRecords", dishRecords);

            resp.sendRedirect("");
        }
    }
}
