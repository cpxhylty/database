package servlet;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("add")) {
            String account = req.getParameter("account");
            String password = req.getParameter("password");
            int type = Integer.parseInt(req.getParameter("type"));

            userService.addUser(account, password, type);

            resp.sendRedirect("");
        }
        else if (operation.equals("sign in")) {
            String account = req.getParameter("account");
            String password = req.getParameter("password");

            int type = userService.signIn(account, password);

            HttpSession session = req.getSession();
            session.setAttribute("type", type);
            if (type != -1) {
                session.setAttribute("account", account);
            }

            resp.sendRedirect("");
        }
    }
}
