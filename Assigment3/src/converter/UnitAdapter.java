package converter;

public class UnitAdapter implements UnitConverter {
    private final UnitConverter system;

    public UnitAdapter(String systemType) {
        if (systemType.equalsIgnoreCase("metric")) {
            system = new MetricSystem();
        } else {
            system = new ImperialSystem();
        }
    }

    @Override
    public double convertLength(double value) {
        return system.convertLength(value);
    }

    @Override
    public double convertWeight(double value) {
        return system.convertWeight(value);
    }

    @Override
    public double convertTemperature(double value) {
        return system.convertTemperature(value);
    }
}
// Adapter