package servlet;

import pojo.Staff;
import pojo.StaffSign;
import pojo.User;
import service.StaffService;
import service.StaffSignService;
import service.impl.StaffServiceImpl;
import service.impl.StaffSignServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class StaffServlet extends HttpServlet {
    StaffService staffService = new StaffServiceImpl();
    StaffSignService staffSignService = new StaffSignServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("get info")) {
            String account = req.getParameter("account");

            StaffSign staffSign = staffSignService.findStaffAndSign(account);

            HttpSession session = req.getSession();
            session.setAttribute("staff sign", staffSign);

            resp.sendRedirect("");
        }
        /*
        if (operation.equals("search")) {
            String account = req.getParameter("account");
            Staff staff = staffService.findStaffByAccountService(account);

            req.setAttribute("staff", staff);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        else if (operation.equals("add")) {
            String account = req.getParameter("account");
            String name = req.getParameter("name");
            String salary = req.getParameter("salary");
            int type = Integer.parseInt(req.getParameter("type"));

            staffService.addStaffService(account, name, salary, type);

            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        else {

        }

         */
    }
}
