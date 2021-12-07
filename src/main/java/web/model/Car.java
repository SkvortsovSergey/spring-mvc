package web.model;

import org.springframework.stereotype.Component;



public class Car {

    private String  model;
    private String engine;
    private String color;

    public Car (String model, String engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public String getModel () {
        return model;
    }

    public String getEngine () {
        return engine;
    }

    public String getColor () {
        return color;
    }

    @Override
    public String toString () {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
