package converter;

public class ImperialSystem implements UnitConverter {
    @Override
    public double convertLength(double value) {
        return value * 3.28084;
    }

    @Override
    public double convertWeight(double value) {
        return value * 2.20462;
    }

    @Override
    public double convertTemperature(double value) {
        return (value * 9/5) + 32;
    }
}
// Adaptee