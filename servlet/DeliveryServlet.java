package servlet;

import pojo.Delivery;
import pojo.Vip;
import service.DeliveryService;
import service.impl.DeliveryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DeliveryServlet extends HttpServlet {
    DeliveryService deliveryService = new DeliveryServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("not arranged")) {

            List<Delivery> deliveries = deliveryService.searchNotArranged();

            HttpSession session = req.getSession();
            session.setAttribute("not arranged", deliveries);

            resp.sendRedirect("");
        }
        else if (operation.equals("take order")) {
            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
            String deliveryMan = req.getParameter("deliveryMan");

            deliveryService.takeOrder(orderNumber, deliveryMan);

            resp.sendRedirect("");
        }
        else if (operation.equals("in delivery")) {
            String deliveryMan = req.getParameter("deliveryMan");

            List<Delivery> deliveries = deliveryService.searchInDelivery(deliveryMan);

            HttpSession session = req.getSession();
            session.setAttribute("in delivery", deliveries);

            resp.sendRedirect("");
        }
        else if (operation.equals("finish")) {
            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));

            deliveryService.finishOrder(orderNumber);

            resp.sendRedirect("");
        }
        else if (operation.equals("history")) {
            String deliveryMan = req.getParameter("deliveryMan");

            List<Delivery> deliveries = deliveryService.lookUpHistory(deliveryMan);

            HttpSession session = req.getSession();
            session.setAttribute("history", deliveries);

            resp.sendRedirect("");
        }
    }
}
