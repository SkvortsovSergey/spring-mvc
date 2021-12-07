package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {
    @GetMapping("/cars")
    public String cars(HttpServletRequest request, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("LADA","1.6","Baklajan") );
        cars.add(new Car("Peugeot","2","Grey"));
        cars.add(new Car("Peugeot","2","Red"));
        cars.add(new Car("Kia","1,6","Red"));
        cars.add(new Car("Kia","1,6","Blue"));
        cars.add(new Car("Kia","1,6","White"));
        model.addAttribute("cars", carsCount(cars, Integer.parseInt(request.getParameter("count"))));
        return "car";
    }
    public static List<Car> carsCount(List<Car> list, Integer count) {
        if (count==null||count == 0 || count >= 5) return list;
        return list.stream().limit(count).collect(Collectors.toList());
    }
}
