package servlet;

import pojo.DishComment;
import pojo.StaffSign;
import service.DishCommentService;
import service.impl.DishCommentServiceImpl;

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

public class DishCommentServlet extends HttpServlet {
    DishCommentService dishCommentService = new DishCommentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("get all")) {

            List<DishComment> dishComments = dishCommentService.getAllDishComments();

            HttpSession session = req.getSession();
            session.setAttribute("dish comments", dishComments);

            resp.sendRedirect("");
        }
        else if (operation.equals("search")) {
            String account = req.getParameter("account");

            List<DishComment> dishComments = dishCommentService.findDishCommentByAccount(account);

            HttpSession session = req.getSession();
            session.setAttribute("user dish comments", dishComments);

            resp.sendRedirect("");
        }
        else if (operation.equals("add")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date time = null;
            String account = req.getParameter("account");int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
            String dish = req.getParameter("dish");
            String content = req.getParameter("content");
            try {
                time = sdf.parse(req.getParameter("time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            dishCommentService.addComment(time, account, dish, content);

            resp.sendRedirect("");
        }
        else if (operation.equals("delete")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date time = null;
            String account = req.getParameter("account");int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
            String dish = req.getParameter("dish");
            try {
                time = sdf.parse(req.getParameter("time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            dishCommentService.deleteComment(time, account, dish);

            resp.sendRedirect("");
        }
    }
}
