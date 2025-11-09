package org.example.travel.elements;

import org.example.travel.visitor.Visitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class TravelPackage implements TripComponent {
    private final String packageName;
    private final List<TripComponent> components = new ArrayList<>();

    public TravelPackage(String packageName) {
        this.packageName = Objects.requireNonNull(packageName);
    }

    public TravelPackage add(TripComponent c) {
        components.add(Objects.requireNonNull(c));
        return this;
    }

    public List<TripComponent> components() {
        return Collections.unmodifiableList(components);
    }

    @Override
    public String name() {
        return "Package " + packageName;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}