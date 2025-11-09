package org.example.travel;

import org.example.travel.elements.*;
import org.example.travel.visitor.*;

public class Demo {
    public static void main(String[] args) {
        TravelPackage pkg = new TravelPackage("Europe Spring 2026")
                .add(new Flight("ALA", "IST", "TK", 350))
                .add(new Hotel("Istanbul Grand", 3, 90))
                .add(new Excursion("Bosporus Cruise", 4, 60))
                .add(new Flight("IST", "CDG", "TK", 220))
                .add(new Hotel("Paris Central", 4, 140))
                .add(new Excursion("Louvre Guided Tour", 3, 85));

        CostVisitor cost = new CostVisitor();
        pkg.accept(cost);

        ItineraryVisitor itinerary = new ItineraryVisitor();
        pkg.accept(itinerary);

        LoyaltyVisitor loyalty = new LoyaltyVisitor();
        pkg.accept(loyalty);

        System.out.println(itinerary.itinerary());
        System.out.printf("Total cost (with taxes & discount policy): %.2f USD%n", cost.total());
        System.out.println("Loyalty points: " + loyalty.points());
    }
}