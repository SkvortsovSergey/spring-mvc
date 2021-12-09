package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarsService {

    public static List<Car> carsCount (List<Car> list, Integer count) {
        if (count == null || count == 0 || count >= 5) return list;
        return list.stream().limit(count).collect(Collectors.toList());
    }
}