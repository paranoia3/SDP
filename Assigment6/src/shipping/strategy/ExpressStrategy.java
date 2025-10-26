package shipping.strategy;

import shipping.model.Region;
import shipping.model.Shipment;
import shipping.money.Money;
import java.math.BigDecimal;

public final class ExpressStrategy implements ShippingCostStrategy {
    private static final BigDecimal BASE = BigDecimal.valueOf(1200);
    private static final BigDecimal PER_KM = BigDecimal.valueOf(40);
    private static final BigDecimal PER_KG = BigDecimal.valueOf(110);
    private static final BigDecimal URGENT_FACTOR = BigDecimal.valueOf(1.5);
    private static final BigDecimal INTERNATIONAL_FACTOR = BigDecimal.valueOf(2.2);

    @Override
    public Money calculate(Shipment s) {
        BigDecimal cost = BASE
                .add(PER_KM.multiply(s.distanceKm()))
                .add(PER_KG.multiply(s.weightKg()))
                .multiply(URGENT_FACTOR);

        if (s.region() == Region.INTERNATIONAL) {
            cost = cost.multiply(INTERNATIONAL_FACTOR);
        }

        if (s.fragile()) cost = cost.add(BigDecimal.valueOf(600));
        if (s.bulky())   cost = cost.add(BigDecimal.valueOf(700));

        return Money.of(cost);
    }

    @Override
    public String name() {
        return "Express";
    }
}