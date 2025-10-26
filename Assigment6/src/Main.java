import shipping.model.Region;
import shipping.model.Shipment;
import shipping.money.Money;
import shipping.service.ShippingCostService;
import shipping.service.StrategyFactory;
import shipping.strategy.*;

public class Main {
    public static void main(String[] args) {
        Shipment macbook = new Shipment.Builder()
                .weightKg(2.1).distanceKm(12)
                .fragile(true).bulky(false)
                .region(Region.URBAN)
                .build();

        Shipment sofa = new Shipment.Builder()
                .weightKg(35).distanceKm(45)
                .fragile(false).bulky(true)
                .region(Region.SUBURBAN)
                .build();

        Shipment giftAbroad = new Shipment.Builder()
                .weightKg(1.2).distanceKm(2500)
                .fragile(true).bulky(false)
                .region(Region.INTERNATIONAL)
                .build();

        ShippingCostService service = new ShippingCostService(
                StrategyFactory.chooseFor(macbook, false)
        );
        print(service, macbook);

        service.setStrategy(new CourierStrategy());
        print(service, sofa);

        service.setStrategy(new PostalStrategy());
        print(service, giftAbroad);

        service.setStrategy(new ExpressStrategy());
        print(service, giftAbroad);

        service.setStrategy(new PickupStrategy());
        print(service, macbook);
    }

    private static void print(ShippingCostService service, Shipment s) {
        Money price = service.quote(s);
        System.out.printf("Strategy: %-8s | Price: %s%n", service.currentStrategyName(), price);
    }
}
