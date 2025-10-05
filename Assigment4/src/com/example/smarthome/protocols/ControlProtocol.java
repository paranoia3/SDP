package com.example.smarthome.protocols;

public interface ControlProtocol {
    String name();
    void sendCommand(String deviceId, String command);
}
