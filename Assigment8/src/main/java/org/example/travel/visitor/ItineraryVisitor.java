package org.example.travel.visitor;

import org.example.travel.elements.*;

public final class ItineraryVisitor implements Visitor {
    private final StringBuilder out = new StringBuilder();

    @Override public void visit(Flight flight) {
        out.append("✈ ").append(flight.name())
                .append(" (").append(flight.basePrice()).append(" USD base)\n");
    }

    @Override public void visit(Hotel hotel) {
        out.append("🏨 ").append(hotel.name())
                .append(" — ").append(hotel.nights()).append(" nights × ")
                .append(hotel.pricePerNight()).append(" USD\n");
    }

    @Override public void visit(Excursion excursion) {
        out.append("🗺 ").append(excursion.name())
                .append(" — ").append(excursion.hours()).append(" h, ")
                .append(excursion.price()).append(" USD\n");
    }

    @Override public void visit(TravelPackage pack) {
        out.append("=== ").append(pack.name()).append(" ===\n");
        for (TripComponent c : pack.components()) c.accept(this);
        out.append("=== end of ").append(pack.name()).append(" ===\n");
    }

    public String itinerary() {
        return out.toString();
    }
}