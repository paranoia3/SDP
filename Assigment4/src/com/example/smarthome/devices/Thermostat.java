package com.example.smarthome.devices;

import com.example.smarthome.protocols.ControlProtocol;

public class Thermostat extends SmartDevice {
    public Thermostat(String id, ControlProtocol protocol) { super(id, protocol); }

    @Override public String type() { return "Thermostat"; }

    @Override public void turnOn()  { protocol.sendCommand(id, "Thermostat ON"); }
    @Override public void turnOff() { protocol.sendCommand(id, "Thermostat OFF"); }

    public void setTemperature(double celsius) {
        protocol.sendCommand(id, "Set TEMP " + celsius + "C");
    }
}
