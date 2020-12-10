package servlet;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("operation").equals("select")) {

            List<User> users = userService.getUser();

            System.out.println(req.getParameter("uname"));
            System.out.println(req.getParameter("pwd"));

            req.setAttribute("users", users);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            String name = req.getParameter("user name");
            int age = Integer.parseInt(req.getParameter("user age"));
            int gender = Integer.parseInt(req.getParameter("user gender"));
            userService.addUser(name,age,gender);
            req.setAttribute("info","insert ok");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }*/
}
