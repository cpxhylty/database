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
import java.util.List;

public class VipServlet extends HttpServlet {
    VipService vipService = new VipServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("get all")) {

            List<Vip> vips = vipService.getAllVips();

            HttpSession session = req.getSession();
            session.setAttribute("vips", vips);

            resp.sendRedirect("");
        }
    }
}
