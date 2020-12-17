package servlet;

import service.SignService;
import service.impl.SignServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignServlet extends HttpServlet {
    SignService signService = new SignServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("add")) {
            String account = req.getParameter("account");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date date = null;
            try {
                date = sdf.parse(req.getParameter("date"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            signService.addSign(account, date);

            resp.sendRedirect("");
        }
    }
}
