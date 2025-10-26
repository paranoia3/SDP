package shipping.strategy;

import shipping.model.Shipment;
import shipping.money.Money;
import java.math.BigDecimal;

public final class PickupStrategy implements ShippingCostStrategy {
    private static final BigDecimal HANDLING = BigDecimal.valueOf(200);

    @Override
    public Money calculate(Shipment s) {
        BigDecimal cost = HANDLING;
        if (s.fragile()) cost = cost.add(BigDecimal.valueOf(150));
        if (s.bulky())   cost = cost.add(BigDecimal.valueOf(150));
        return Money.of(cost);
    }

    @Override
    public String name() {
        return "Pickup";
    }
}