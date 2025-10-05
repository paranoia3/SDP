package com.example.smarthome.protocols;

public class BluetoothControl implements ControlProtocol {
    @Override public String name() { return "Bluetooth"; }
    @Override public void sendCommand(String deviceId, String command) {
        System.out.println("[Bluetooth] -> (" + deviceId + "): " + command);
    }
}
