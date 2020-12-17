package pojo;

import java.util.Date;

public class Meal {
    private int orderNumber;
    private float price;
    private String waiter;
    private int seatNumber;
    private String user;
    private Date date;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }
}
