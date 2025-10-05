package com.example.smarthome.protocols;

public class WiFiControl implements ControlProtocol {
    @Override public String name() { return "Wi-Fi"; }
    @Override public void sendCommand(String deviceId, String command) {
        System.out.println("[Wi-Fi] -> (" + deviceId + "): " + command);
    }
}
