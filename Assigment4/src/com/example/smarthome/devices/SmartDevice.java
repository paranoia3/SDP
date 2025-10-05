package com.example.smarthome.devices;

import com.example.smarthome.protocols.ControlProtocol;

public abstract class SmartDevice {
    protected final String id;
    protected ControlProtocol protocol;

    protected SmartDevice(String id, ControlProtocol protocol) {
        this.id = id;
        this.protocol = protocol;
    }

    public void setProtocol(ControlProtocol protocol) { this.protocol = protocol; }
    public String protocolName() { return protocol != null ? protocol.name() : "None"; }

    public abstract String type();
    public abstract void turnOn();
    public abstract void turnOff();
}
