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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryServlet extends HttpServlet {
    DeliveryService deliveryService = new DeliveryServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = (String) req.getSession().getAttribute("operation");
        System.out.println(operation);
        if (operation.equals("not arranged")) {
            List<Delivery> deliveries = deliveryService.searchNotArranged();

            HttpSession session = req.getSession();
            session.setAttribute("not arranged", deliveries);
            System.out.println("ok");
            resp.sendRedirect("/db_war_exploded/staff/delivery-admin-begin.jsp");
        }
        else if (operation.equals("take order")) {
            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
            String deliveryMan = req.getParameter("deliveryMan");

            deliveryService.takeOrder(orderNumber, deliveryMan);

            resp.sendRedirect("");
        }
        else if (operation.equals("in delivery")) {
            String deliveryMan = (String) req.getSession().getAttribute("account");
            List<Delivery> deliveries = deliveryService.searchInDelivery(deliveryMan);

            HttpSession session = req.getSession();
            session.setAttribute("in delivery", deliveries);

            resp.sendRedirect("/db_war_exploded/staff/delivery-admin-waiting.jsp");
        }
        else if (operation.equals("finish")) {
            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));

            deliveryService.finishOrder(orderNumber);

            resp.sendRedirect("");
        }
        else if (operation.equals("history")) {
            String deliveryMan = (String) req.getSession().getAttribute("account");

            List<Delivery> deliveries = deliveryService.lookUpHistory(deliveryMan);

            HttpSession session = req.getSession();
            session.setAttribute("history", deliveries);

            resp.sendRedirect("/db_war_exploded/staff/delivery-admin-complete.jsp");
        }
        else if (operation.equals("make order")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date time = null;
            String account = req.getParameter("account");
            float price = Float.parseFloat(req.getParameter("price"));
            String address = req.getParameter("address");
            int number = Integer.parseInt(req.getParameter("number"));
            List<String> names = new ArrayList<>();
            List<Integer> numbers = new ArrayList<>();
            try {
                time=sdf.parse(req.getParameter("time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < number; i++) {
                names.add(req.getParameter("name"+Integer.toString(i)));
                numbers.add(Integer.parseInt(req.getParameter("number"+Integer.toString(i))));
            }

            deliveryService.makeOrder(time, account, price, address, number, names, numbers);

            resp.sendRedirect("");
        }
    }
}
