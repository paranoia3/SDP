package com.example.smarthome.devices;

import com.example.smarthome.protocols.ControlProtocol;

public class Lamp extends SmartDevice {
    public Lamp(String id, ControlProtocol protocol) { super(id, protocol); }

    @Override public String type() { return "Lamp"; }

    @Override public void turnOn()  { protocol.sendCommand(id, "Lamp ON"); }
    @Override public void turnOff() { protocol.sendCommand(id, "Lamp OFF"); }

    public void dim(int percent) {
        protocol.sendCommand(id, "Lamp DIM " + Math.max(0, Math.min(100, percent)) + "%");
    }
}
