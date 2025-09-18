import models.Car;
import models.Report;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Car car = new Car.Builder()
                .model("Audi")
                .color("Black")
                .speed(300)
                .year(2023)
                .build();

        System.out.println(car);

    }

}