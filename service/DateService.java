package service;

import pojo.Delivery;
import pojo.Meal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface DateService {
    List<String> getLatest12Month(LocalDate localDate,int num);

    ArrayList<Integer> getDeliveryDateList(List<Delivery> deliveries);

    ArrayList<Integer> getMealDateList(List<Meal> meals);
}
