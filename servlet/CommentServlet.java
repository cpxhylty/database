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

            resp.sendRedirect("");
        }
    }
}
