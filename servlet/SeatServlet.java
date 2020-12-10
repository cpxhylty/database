package servlet;

import pojo.Seat;
import service.SeatService;
import service.impl.SeatServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SeatServlet extends HttpServlet {
    SeatService seatService = new SeatServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("get info")) {
            List<Seat> seats = seatService.getAllSeats();

            HttpSession session = req.getSession();
            session.setAttribute("seats", seats);

            resp.sendRedirect("");
        }
        else if (operation.equals("start")) {
            int seatNumber = Integer.parseInt(req.getParameter("seatNumber"));

            seatService.startMeal(seatNumber);

            resp.sendRedirect("");
        }
        else if (operation.equals("end")) {
            int seatNumber = Integer.parseInt(req.getParameter("seatNumber"));

            seatService.endMeal(seatNumber);

            resp.sendRedirect("");
        }
    }
}
