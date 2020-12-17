package service.impl;

import pojo.Delivery;
import pojo.Meal;
import service.DateService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DateServiceImpl implements DateService {
    @Override
    public List<String> getLatest12Month(LocalDate date, int num) {
        List<String> monthList = new ArrayList<>();
        for(int i = 0;i <= num-1; i++){
            LocalDate localDate = date.minusMonths(i);
            String month = localDate.toString().substring(0,7);
            monthList.add(month);
            System.out.println(month);
        }
        return monthList;
    }

    @Override
    public ArrayList<Integer> getDeliveryDateList(List<Delivery> deliveries) {
        int [] array = new int[]{0, 0, 0, 0, 0, 0};
        List<String> stringList = getLatest12Month(LocalDate.now(),6);
        for (int i = 0;i < 6;i++) {
            for (Delivery delivery : deliveries) {
                if (delivery.getTime().toString().substring(0, 7).equals(stringList.get(i))) {
                    array[i]++;
                }
            }
        }
        return new ArrayList<Integer>(Arrays.asList(array[0],array[1],array[2],array[3],array[4],array[5]));
    }

    @Override
    public ArrayList<Integer> getMealDateList(List<Meal> meals) {
        int [] array = new int[]{0, 0, 0, 0, 0, 0};
        List<String> stringList = getLatest12Month(LocalDate.now(),6);
        for (int i = 0;i < 6;i++) {
            for (Meal meal : meals) {
                if (meal.getDate().toString().substring(0, 7).equals(stringList.get(i))) {
                    array[i]++;
                }
            }
        }
        return new ArrayList<Integer>(Arrays.asList(array[0],array[1],array[2],array[3],array[4],array[5]));
    }
}
