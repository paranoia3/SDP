package shipping.service;

import shipping.model.Region;
import shipping.model.Shipment;
import shipping.strategy.*;
import java.util.Objects;

public final class StrategyFactory {

    private StrategyFactory() {}

    public static ShippingCostStrategy chooseFor(Shipment s, boolean needFastest) {
        Objects.requireNonNull(s, "shipment");

        if (needFastest) return new ExpressStrategy();
        if (s.region() == Region.URBAN || s.region() == Region.SUBURBAN) return new CourierStrategy();
        if (s.region() == Region.INTERNATIONAL) return new PostalStrategy();
        return new PostalStrategy();
    }
}