package com.example.smarthome;

import com.example.smarthome.devices.*;
import com.example.smarthome.protocols.*;

public class Demo {
    public static void main(String[] args) {
        ControlProtocol wifi = new WiFiControl();
        ControlProtocol bt   = new BluetoothControl();
        ControlProtocol zb   = new ZigBeeControl();

        SmartDevice lamp = new Lamp("lamp-01", wifi);
        SmartDevice thermo = new Thermostat("thermo-01", bt);
        SmartDevice door = new DoorLock("door-01", zb);

        lamp.turnOn();
        ((Lamp) lamp).dim(40);
        thermo.turnOn();
        ((Thermostat) thermo).setTemperature(22.5);
        door.turnOn();

        System.out.println("--- Switch protocols at runtime ---");
        lamp.setProtocol(zb);
        thermo.setProtocol(wifi);
        door.setProtocol(bt);

        lamp.turnOff();
        ((Thermostat) thermo).setTemperature(19.0);
        door.turnOff();
    }
}
