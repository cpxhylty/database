package servlet;

import pojo.Comment;
import pojo.Vip;
import service.VipService;
import service.impl.VipServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VipServlet extends HttpServlet {
    VipService vipService = new VipServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation =  req.getParameter("operation");
        if (operation.equals("get all")) {

            List<Vip> vips = vipService.getAllVips();

            HttpSession session = req.getSession();
            session.setAttribute("vips", vips);

            resp.sendRedirect("/db_war_exploded/staff/waiter-admin-vip.jsp");
        } else if (operation.equals("search")) {
            String account = req.getParameter("account");

            List<Vip> vips = vipService.searchByAccount(account);

            HttpSession session = req.getSession();
            session.setAttribute("vips", vips);

            resp.sendRedirect("");
        }
        else if (operation.equals("add")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String account = req.getParameter("account");
            Date registerTime = null;
            Date endTime = null;
            try {
                registerTime = sdf.parse(req.getParameter("registerTime"));
                endTime = sdf.parse(req.getParameter("endTime"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            float money = Float.parseFloat(req.getParameter("money"));


            vipService.addVip(account, registerTime, endTime, money);

            List<Vip> vips = vipService.getAllVips();

            HttpSession session = req.getSession();
            session.setAttribute("vips", vips);

            resp.sendRedirect("/db_war_exploded/staff/waiter-admin-vip.jsp");
        }
        else if (operation.equals("delete")) {
            String account = req.getParameter("account");

            vipService.deleteVip(account);

            List<Vip> vips = vipService.getAllVips();

            HttpSession session = req.getSession();
            session.setAttribute("vips", vips);

            resp.sendRedirect("/db_war_exploded/staff/waiter-admin-vip.jsp");
        }
        else if (operation.equals("increase")) {
            String account = req.getParameter("account");
            float money = Float.parseFloat(req.getParameter("money"));

            vipService.increaseMoney(account, money);

            resp.sendRedirect("");
        }
        else if (operation.equals("decrease")) {
            String account = req.getParameter("account");
            float money = Float.parseFloat(req.getParameter("money"));

            vipService.decreaseMoney(account, money);

            resp.sendRedirect("");
        }
    }
}
