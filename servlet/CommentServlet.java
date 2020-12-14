package servlet;

import pojo.Comment;
import pojo.DishComment;
import service.CommentService;
import service.impl.CommentServiceImpl;

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

public class CommentServlet extends HttpServlet {
    CommentService commentService = new CommentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("get all")) {

            List<Comment> comments = commentService.getAllComments();

            HttpSession session = req.getSession();
            session.setAttribute("comments", comments);

            resp.sendRedirect("/db_war_exploded/staff/waiter-admin-evaluate.jsp");
        }
        else if (operation.equals("search")) {
            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));

            Comment comment = commentService.findCommentByOrder(orderNumber);

            HttpSession session = req.getSession();
            session.setAttribute("comment", comment);

            resp.sendRedirect("");
        }
        else if (operation.equals("add")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
            int type = Integer.parseInt(req.getParameter("type"));
            String name = req.getParameter("name");
            String content = req.getParameter("content");
            int rating = Integer.parseInt(req.getParameter("rating"));
            Date time = null;
            try {
                time = sdf.parse(req.getParameter("time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            commentService.addComment(orderNumber, type, name, content, rating, time);

            resp.sendRedirect("");
        }
        else if (operation.equals("update")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
            String name = req.getParameter("name");
            String content = req.getParameter("content");
            int rating = Integer.parseInt(req.getParameter("rating"));
            Date time = null;
            try {
                time = sdf.parse(req.getParameter("time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            commentService.updateComment(orderNumber, name, content, rating, time);

            resp.sendRedirect("");
        }
        else if (operation.equals("delete")) {
            int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));

            commentService.deleteComment(orderNumber);

            resp.sendRedirect("");
        }
    }
}
