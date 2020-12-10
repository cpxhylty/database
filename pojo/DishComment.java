package pojo;

import java.util.Date;

public class DishComment {
    Date time;
    String user;
    String dish;
    String content;

    public Date getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public String getDish() {
        return dish;
    }

    public String getUser() {
        return user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
