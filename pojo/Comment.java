package pojo;

import java.util.Date;

public class Comment {
    private int orderNumber;
    private Date time;
    private int type;
    private String name;
    private String content;
    private int rating;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }


}
