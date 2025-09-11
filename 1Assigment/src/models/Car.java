package models;

import java.util.UUID;

public class Car {

    private UUID uniqueId;

    private String model;
    private int year;
    private String color;
    private int speed;

    private Car(Builder builder) {
        this.uniqueId = UUID.randomUUID();
        this.model = builder.model;
        this.year = builder.year;
        this.color = builder.color;
        this.speed = builder.speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "uniqueId=" + uniqueId +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }

    public static class Builder {

        private String model;
        private int year;
        private String color;
        private int speed;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

}