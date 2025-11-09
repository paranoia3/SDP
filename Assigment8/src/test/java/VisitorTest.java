import org.example.travel.elements.*;
import org.example.travel.visitor.*;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VisitorTest {
    @Test
    void costAndPointsAreCalculated() {
        TravelPackage p = new TravelPackage("Test")
                .add(new Flight("A", "B", "X", 500))
                .add(new Hotel("H", 2, 100))
                .add(new Excursion("E", 4, 50));

        CostVisitor cost = new CostVisitor();
        LoyaltyVisitor lo = new LoyaltyVisitor();

        p.accept(cost);
        p.accept(lo);

        assertTrue(cost.total() > 0);
        assertTrue(lo.points() > 0);
    }
}