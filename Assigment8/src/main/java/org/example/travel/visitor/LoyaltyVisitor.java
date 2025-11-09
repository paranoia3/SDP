package org.example.travel.visitor;

import org.example.travel.elements.*;

public final class LoyaltyVisitor implements Visitor {
    private int points = 0;

    @Override
    public void visit(Flight flight) {
        points += (int) Math.round(flight.basePrice() / 10.0);
    }

    @Override
    public void visit(Hotel hotel) {
        points += hotel.nights() * 5;
    }

    @Override
    public void visit(Excursion excursion) {
        points += Math.max(1, excursion.hours() / 2);
    }

    @Override
    public void visit(TravelPackage pack) {
        for (TripComponent c : pack.components()) c.accept(this);
    }

    public int points() {
        return points;
    }
}