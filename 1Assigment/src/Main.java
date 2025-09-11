import models.Car;
import models.Report;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Car car = new Car.Builder()
                .model("BMW")
                .color("Black")
                .speed(320)
                .year(2021)
                .build();

        System.out.println(car);

        Report report = new Report.Builder()
                .title("My first report")
                .messages(Arrays.asList(
                        "Hello world",
                        "it works!"
                ))
                .build();

        System.out.println(report);

    }

}