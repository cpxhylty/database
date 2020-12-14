package pojo;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<List<Dish>> menu;

    public Menu() {
        menu = new ArrayList<>();
    }

    public void addDishes(List<Dish> dishes) {
        menu.add(dishes);
    }

    public List<List<Dish>> getMenu() {
        return menu;
    }
}
