package org.example.travel.visitor;

import org.example.travel.elements.*;

public final class CostVisitor implements Visitor {
    private double subtotal = 0.0;

    private static final double FLIGHT_TAX = 0.12;
    private static final double HOTEL_TAX  = 0.08;
    private static final double EXCURSION_TAX = 0.05;
    private static final double SEASONAL_DISCOUNT = 0.10;

    @Override public void visit(Flight flight) {
        subtotal += flight.basePrice() * (1 + FLIGHT_TAX);
    }

    @Override public void visit(Hotel hotel) {
        double cost = hotel.nights() * hotel.pricePerNight();
        subtotal += cost * (1 + HOTEL_TAX);
    }

    @Override public void visit(Excursion excursion) {
        subtotal += excursion.price() * (1 + EXCURSION_TAX);
    }

    @Override public void visit(TravelPackage pack) {
        for (TripComponent c : pack.components()) c.accept(this);
    }

    public double total() {
        return applySeasonalDiscount(subtotal);
    }

    private double applySeasonalDiscount(double amount) {
        return amount > 1000 ? amount * (1 - SEASONAL_DISCOUNT) : amount;
    }
}