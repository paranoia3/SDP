package converter;

public class MetricSystem implements UnitConverter {
    @Override
    public double convertLength(double value) {
        return value;
    }

    @Override
    public double convertWeight(double value) {
        return value;
    }

    @Override
    public double convertTemperature(double value) {
        return value;
    }
}
//  Adaptee