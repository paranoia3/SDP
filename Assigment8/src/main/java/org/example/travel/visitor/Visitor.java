package org.example.travel.visitor;

import org.example.travel.elements.*;

public interface Visitor {
    void visit(Flight flight);
    void visit(Hotel hotel);
    void visit(Excursion excursion);
    void visit(TravelPackage travelPackage);
}