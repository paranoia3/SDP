package org.example.travel.elements;

import org.example.travel.visitor.Visitor;
import java.util.Objects;

public final class Hotel implements TripComponent {
    private final String hotelName;
    private final int nights;
    private final double pricePerNight;

    public Hotel(String hotelName, int nights, double pricePerNight) {
        this.hotelName = Objects.requireNonNull(hotelName);
        if (nights <= 0) throw new IllegalArgumentException("nights must be > 0");
        if (pricePerNight < 0) throw new IllegalArgumentException("pricePerNight must be >= 0");
        this.nights = nights;
        this.pricePerNight = pricePerNight;
    }

    public String hotelName() { return hotelName; }
    public int nights() { return nights; }
    public double pricePerNight() { return pricePerNight; }

    @Override
    public String name() {
        return "Hotel " + hotelName;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}