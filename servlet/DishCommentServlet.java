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
    }
}
