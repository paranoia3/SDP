package shipping.strategy;

import shipping.model.Region;
import shipping.model.Shipment;
import shipping.money.Money;
import java.math.BigDecimal;

public final class CourierStrategy implements ShippingCostStrategy {
    private static final BigDecimal BASE = BigDecimal.valueOf(700);
    private static final BigDecimal PER_KM = BigDecimal.valueOf(25);
    private static final BigDecimal PER_KG = BigDecimal.valueOf(90);
    private static final BigDecimal FRAGILE_SURCHARGE = BigDecimal.valueOf(500);
    private static final BigDecimal BULKY_SURCHARGE   = BigDecimal.valueOf(600);
    private static final BigDecimal SUBURBAN_FACTOR   = BigDecimal.valueOf(1.15);
    private static final BigDecimal REMOTE_FACTOR     = BigDecimal.valueOf(1.35);

    @Override
    public Money calculate(Shipment s) {
        BigDecimal cost = BASE
                .add(PER_KM.multiply(s.distanceKm()))
                .add(PER_KG.multiply(s.weightKg()));

        if (s.fragile()) cost = cost.add(FRAGILE_SURCHARGE);
        if (s.bulky())   cost = cost.add(BULKY_SURCHARGE);

        if (s.region() == Region.SUBURBAN) {
            cost = cost.multiply(SUBURBAN_FACTOR);
        } else if (s.region() == Region.REMOTE) {
            cost = cost.multiply(REMOTE_FACTOR);
        }

        return Money.of(cost);
    }

    @Override
    public String name() {
        return "Courier";
    }
}