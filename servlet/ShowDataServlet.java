package servlet;

import service.DishService;
import service.StaffService;
import service.UserService;
import service.impl.DishServiceImpl;
import service.impl.StaffServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowDataServlet")
public class ShowDataServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String oper = req.getParameter("oper");
        if ("changeSalary".equals(oper)) {
            ChangeSalary(req,resp);
            return;
        }
        else if("addStaff".equals(oper)) {
            addStaff(req,resp);
            return;
        }
        else if("changeDish".equals(oper)) {
            changeDish(req,resp);
            return;
        }
        else if ("addDish".equals(oper)) {
            addDish(req,resp);
        }
    }

    private void addDish(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String dishName = req.getParameter("dishName");
        String dishPrice = req.getParameter("dishPrice");
        String dishStock = req.getParameter("dishStock");
        String vipPrice = req.getParameter("vipPrice");
        String url = req.getParameter("url");
        DishService dishService = new DishServiceImpl();
        dishService.addNewDish(dishName,dishPrice,dishStock,vipPrice,url);
        resp.sendRedirect("canteen/addDish.jsp");
    }

    private void changeDish(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String dishName = req.getParameter("dishName");
        String dishPrice = req.getParameter("dishPrice");
        String dishStock = req.getParameter("dishStock");
        String vipPrice = req.getParameter("vipPrice");
        DishService dishService = new DishServiceImpl();
        dishService.changeDish(dishName,dishPrice,dishStock,vipPrice);
        resp.sendRedirect("canteen/manageDish.jsp");
    }

    private void addStaff(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String staffName = req.getParameter("staffName");
        String staffAccount = req.getParameter("staffAccount");
        String staffPwd = req.getParameter("staffPwd");
        String job = req.getParameter("selector1");
        String staffSalary = req.getParameter("staffSalary");
        int type = 0;
        if ("服务员".equals(job)) {
            type = 0;
        }
        else if ("厨师".equals(job)) {
            type = 1;
        }
        else if ("配送员".equals(job)) {
            type = 2;
        }
        StaffService staffService = new StaffServiceImpl();
        staffService.addStaffService(staffAccount,staffName,Float.parseFloat(staffSalary),type);
        UserService userService = new UserServiceImpl();
        userService.addUser(staffAccount,staffPwd,type);
        resp.sendRedirect("/canteen/addStaff.jsp");
    }

    private void ChangeSalary(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String salary = req.getParameter("salary");
        String staffAccount = req.getParameter("staffAccount");
        StaffService staffService = new StaffServiceImpl();
        if (salary!=null) {
            staffService.changeSalary(salary,staffAccount);
        }
        else {
            staffService.deleteStaffService(staffAccount);
        }
        resp.sendRedirect("/canteen/manageStaff.jsp");
    }
}
