package pojo;

public class Evaluate {
    private int id;
    private String dinnerTime;
    private int type;
    private String name;
    private String content;
    private int rating;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDinnerTime(String dinnerTime) {
        this.dinnerTime = dinnerTime;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public String getDinnerTime() {
        return dinnerTime;
    }
}
