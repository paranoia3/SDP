package org.example.travel.elements;

import org.example.travel.visitor.Visitor;
import java.util.Objects;

public final class Flight implements TripComponent {
    private final String from;
    private final String to;
    private final String carrier;
    private final double basePrice; // USD

    public Flight(String from, String to, String carrier, double basePrice) {
        this.from = Objects.requireNonNull(from);
        this.to = Objects.requireNonNull(to);
        this.carrier = Objects.requireNonNull(carrier);
        if (basePrice < 0) throw new IllegalArgumentException("basePrice must be >= 0");
        this.basePrice = basePrice;
    }

    public String from() { return from; }
    public String to() { return to; }
    public String carrier() { return carrier; }
    public double basePrice() { return basePrice; }

    @Override
    public String name() {
        return "Flight " + carrier + " " + from + "→" + to;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}