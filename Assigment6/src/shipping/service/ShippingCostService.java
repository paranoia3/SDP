package shipping.service;

import shipping.model.Shipment;
import shipping.money.Money;
import shipping.strategy.ShippingCostStrategy;
import java.util.Objects;

public final class ShippingCostService {
    private ShippingCostStrategy strategy;

    public ShippingCostService(ShippingCostStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy");
    }

    public Money quote(Shipment shipment) {
        return strategy.calculate(shipment);
    }

    public void setStrategy(ShippingCostStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy");
    }

    public String currentStrategyName() {
        return strategy.name();
    }
}