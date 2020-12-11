package pojo;

import java.util.List;

public class CustomerHistory {
    private List<Integer> commented;
    private List<Delivery> deliveries;
    private List<Meal> meals;

    public List<Integer> getCommented() {
        return commented;
    }

    public void setCommented(List<Integer> commented) {
        this.commented = commented;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
