package shipping.strategy;

import shipping.model.Shipment;
import shipping.money.Money;

public interface ShippingCostStrategy {
    Money calculate(Shipment shipment);
    String name();
}

