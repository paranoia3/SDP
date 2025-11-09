package org.example.travel.elements;

import org.example.travel.visitor.Visitor;

import java.util.Objects;

public final class Excursion implements TripComponent {
    private final String title;
    private final int hours;
    private final double price;

    public Excursion(String title, int hours, double price) {
        this.title = Objects.requireNonNull(title);
        if (hours <= 0) throw new IllegalArgumentException("hours must be > 0");
        if (price < 0) throw new IllegalArgumentException("price must be >= 0");
        this.hours = hours;
        this.price = price;
    }

    public String title() { return title; }
    public int hours() { return hours; }
    public double price() { return price; }

    @Override
    public String name() {
        return "Excursion " + title;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}