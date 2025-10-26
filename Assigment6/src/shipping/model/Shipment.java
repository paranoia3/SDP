package shipping.model;

import java.util.Objects;
import java.math.BigDecimal;

public final class Shipment {
    private final BigDecimal weightKg;
    private final BigDecimal distanceKm;
    private final boolean fragile;
    private final boolean bulky;
    private final Region region;

    private Shipment(Builder b) {
        this.weightKg = b.weightKg;
        this.distanceKm = b.distanceKm;
        this.fragile = b.fragile;
        this.bulky = b.bulky;
        this.region = Objects.requireNonNull(b.region, "region");
    }

    public BigDecimal weightKg() { return weightKg; }
    public BigDecimal distanceKm() { return distanceKm; }
    public boolean fragile() { return fragile; }
    public boolean bulky() { return bulky; }
    public Region region() { return region; }

    public static class Builder {
        private BigDecimal weightKg = BigDecimal.ZERO;
        private BigDecimal distanceKm = BigDecimal.ZERO;
        private boolean fragile;
        private boolean bulky;
        private Region region = Region.URBAN;

        public Builder weightKg(double kg) { this.weightKg = BigDecimal.valueOf(kg); return this; }
        public Builder distanceKm(double km) { this.distanceKm = BigDecimal.valueOf(km); return this; }
        public Builder fragile(boolean f) { this.fragile = f; return this; }
        public Builder bulky(boolean b) { this.bulky = b; return this; }
        public Builder region(Region r) { this.region = r; return this; }

        public Shipment build() {
            if (weightKg.signum() < 0 || distanceKm.signum() < 0)
                throw new IllegalArgumentException("weight/distance must be >= 0");
            return new Shipment(this);
        }
    }
}