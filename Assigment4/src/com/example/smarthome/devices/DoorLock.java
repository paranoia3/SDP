package com.example.smarthome.devices;

import com.example.smarthome.protocols.ControlProtocol;

public class DoorLock extends SmartDevice {
    public DoorLock(String id, ControlProtocol protocol) { super(id, protocol); }

    @Override public String type() { return "DoorLock"; }

    @Override public void turnOn()  { lock(); }
    @Override public void turnOff() { unlock(); }

    public void lock()   { protocol.sendCommand(id, "LOCK"); }
    public void unlock() { protocol.sendCommand(id, "UNLOCK"); }
}
