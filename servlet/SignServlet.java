package servlet;

import service.SignService;
import service.impl.SignServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignServlet extends HttpServlet {
    SignService signService = new SignServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("add")) {
            String account = req.getParameter("account");
            int date = Integer.parseInt(req.getParameter("date"));

            signService.addSign(account, date);

            resp.sendRedirect("");
        }
    }
}
