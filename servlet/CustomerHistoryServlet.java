package servlet;

import pojo.CustomerHistory;
import service.CustomerHistoryService;
import service.impl.CustomerHistoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomerHistoryServlet extends HttpServlet {
    CustomerHistoryService customerHistoryService = new CustomerHistoryServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = (String) req.getSession().getAttribute("operation");
        if (operation.equals("get")) {
            String account = (String) req.getSession().getAttribute("account");
            CustomerHistory customerHistory = customerHistoryService.findCustomerHistory(account);

            HttpSession session = req.getSession();
            session.setAttribute("customer history", customerHistory);

            resp.sendRedirect("/db_war_exploded/user/info.jsp");
        }
    }
}
