package com.example.smarthome.protocols;

public class ZigBeeControl implements ControlProtocol {
    @Override public String name() { return "ZigBee"; }
    @Override public void sendCommand(String deviceId, String command) {
        System.out.println("[ZigBee] -> (" + deviceId + "): " + command);
    }
}
