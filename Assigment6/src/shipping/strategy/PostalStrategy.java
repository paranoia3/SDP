package shipping.strategy;

import shipping.model.Region;
import shipping.model.Shipment;
import shipping.money.Money;
import java.math.BigDecimal;

public final class PostalStrategy implements ShippingCostStrategy {
    private static final BigDecimal BASE = BigDecimal.valueOf(400);
    private static final BigDecimal PER_KG = BigDecimal.valueOf(60);
    private static final BigDecimal REMOTE_FACTOR = BigDecimal.valueOf(1.25);
    private static final BigDecimal INTERNATIONAL_FACTOR = BigDecimal.valueOf(3.2);

    @Override
    public Money calculate(Shipment s) {
        BigDecimal cost = BASE.add(PER_KG.multiply(s.weightKg()));

        if (s.region() == Region.REMOTE) {
            cost = cost.multiply(REMOTE_FACTOR);
        } else if (s.region() == Region.INTERNATIONAL) {
            cost = cost.multiply(INTERNATIONAL_FACTOR);
        }

        if (s.fragile()) {
            cost = cost.add(BigDecimal.valueOf(250));
        }
        if (s.bulky()) {
            cost = cost.add(BigDecimal.valueOf(350));
        }

        return Money.of(cost);
    }

    @Override
    public String name() {
        return "Postal";
    }
}