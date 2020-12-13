package servlet;

import pojo.Staff;
import pojo.User;
import service.CustomerService;
import service.StaffService;
import service.UserService;
import service.impl.CustomerServiceImpl;
import service.impl.StaffServiceImpl;
import service.impl.UserServiceImpl;

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
import java.util.Enumeration;
import java.util.List;

public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    StaffService staffService = new StaffServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("add staff")) {

            String account = req.getParameter("account");
            String password = req.getParameter("password");
            int type = Integer.parseInt(req.getParameter("type"));
            String name = req.getParameter("name");

            userService.addUser(account, password, type);
            staffService.addStaffService(account, name, 0, type);

            resp.sendRedirect("/db_war_exploded/login.jsp");
        }
        else if (operation.equals("add customer")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String account = req.getParameter("account");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            Date time = null;
            try {
                time = sdf.parse(req.getParameter("time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }


            userService.addUser(account, password, 0);
            customerService.addCustomer(account, time, name);

            resp.sendRedirect("/db_war_exploded/login.jsp");
        }
        else if (operation.equals("sign in")) {
            String account = req.getParameter("account");
            String password = req.getParameter("password");

            int type = userService.signIn(account, password);

            HttpSession session = req.getSession();
            session.setAttribute("type", type);
            if (type != -1) {
                session.setAttribute("account", account);
                if (type == 0) {
                    session.setAttribute("customer", customerService.findCustomerByAccount(account));
                }
                else if (1 <= type && type <= 4) {
                    session.setAttribute("staff", staffService.findStaffByAccountService(account));
                }
            }


            resp.sendRedirect("/db_war_exploded/login.jsp");
        }
        else if (operation.equals("exit")) {
            HttpSession session = req.getSession();
            Enumeration enumeration = session.getAttributeNames();
            while (enumeration.hasMoreElements()) {
                session.removeAttribute(enumeration.nextElement().toString());
            }
            resp.sendRedirect("");
        }
    }
}
