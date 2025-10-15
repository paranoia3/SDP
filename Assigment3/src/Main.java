import converter.UnitConverter;
import converter.UnitAdapter;

public class Main {
    public static void main(String[] args) {
        UnitConverter metricConverter = new UnitAdapter("metric");
        System.out.println("Metric System:");
        System.out.println("Length in meters: " + metricConverter.convertLength(10));
        System.out.println("Weight in kilograms: " + metricConverter.convertWeight(50));
        System.out.println("Temperature in Celsius: " + metricConverter.convertTemperature(25));

        UnitConverter imperialConverter = new UnitAdapter("imperial");
        System.out.println("\nImperial System:");
        System.out.println("Length in feet: " + imperialConverter.convertLength(10));
        System.out.println("Weight in pounds: " + imperialConverter.convertWeight(50));
        System.out.println("Temperature in Fahrenheit: " + imperialConverter.convertTemperature(25));
    }
}
// Client