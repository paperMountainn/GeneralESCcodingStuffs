package com.example.sumsquarederrortriangulation;

/**
 *wifiAP class can create wifiAP objects, in which we use to store the wifiAPs
 */
public class OneAPScan {
    private String wifiApName;
    private String macAddress;
    private double signalStrength;
    private String location;

    public OneAPScan(String wifiApName, String macAddress, double signalStrength) {
        this.wifiApName = wifiApName;
        this.macAddress = macAddress;
        this.signalStrength = signalStrength;
    }

    public String getWifiApName() {
        return wifiApName;
    }

    public void setWifiApName(String wifiApName) {
        this.wifiApName = wifiApName;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public double getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(double signalStrength) {
        this.signalStrength = signalStrength;
    }
}
