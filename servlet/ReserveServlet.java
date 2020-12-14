package servlet;

import pojo.Reserve;
import service.ReserveService;
import service.impl.ReserveServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ReserveServlet extends HttpServlet {
    ReserveService reserveService = new ReserveServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("search")) {
            int month = Integer.parseInt(req.getParameter("month"));
            int day = Integer.parseInt(req.getParameter("day"));
            int type = Integer.parseInt(req.getParameter("type"));

            List<Integer> seats = reserveService.getVacantSeat(month, day, type);

            HttpSession session = req.getSession();
            session.setAttribute("seats", seats);

            resp.sendRedirect("");
        }
        else if (operation.equals("create")) {
            String account = req.getParameter("account");
            int month = Integer.parseInt(req.getParameter("month"));
            int day = Integer.parseInt(req.getParameter("day"));
            int type = Integer.parseInt(req.getParameter("type"));
            int seatNumber = Integer.parseInt(req.getParameter("seatNumber"));

            reserveService.createReservation(account, month, day, type, seatNumber);

            resp.sendRedirect("");
        }
        else if (operation.equals("get all")) {

            List<Reserve> reserves = reserveService.getAllReserves();

            HttpSession session = req.getSession();
            session.setAttribute("reserves", reserves);

            resp.sendRedirect("");
        }
        else if (operation.equals("get by day")) {
            int month = Integer.parseInt(req.getParameter("month"));
            int day = Integer.parseInt(req.getParameter("day"));

            List<Reserve> reserves = reserveService.getReservesByDate(month, day);

            HttpSession session = req.getSession();
            session.setAttribute("reserves", reserves);

            resp.sendRedirect("");
        }
        else if (operation.equals("delete")) {
            int month = Integer.parseInt(req.getParameter("month"));
            int day = Integer.parseInt(req.getParameter("day"));
            int type = Integer.parseInt(req.getParameter("type"));
            int seatNumber = Integer.parseInt(req.getParameter("seatNumber"));

            reserveService.deleteReserve(month, day, type, seatNumber);

            resp.sendRedirect("");
        }
    }
}
