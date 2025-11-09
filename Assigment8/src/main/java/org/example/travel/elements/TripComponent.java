package org.example.travel.elements;

import org.example.travel.visitor.Visitor;

public interface TripComponent {
    String name();
    void accept(Visitor visitor);
}