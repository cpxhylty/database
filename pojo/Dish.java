package pojo;

public class Dish {
    private String name;
    private double price;
    private int surplus;
    private double vipPrice;
    private String url;

    public Dish() {

    }

    public Dish(String name,double price,int surplus,double vipPrice,String url) {
        this.name = name;
        this.price = price;
        this.surplus = surplus;
        this.vipPrice = vipPrice;
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getVipPrice() {
        return vipPrice;
    }

    public int getSurplus() {
        return surplus;
    }

    public String getUrl() {
        return url;
    }
}
