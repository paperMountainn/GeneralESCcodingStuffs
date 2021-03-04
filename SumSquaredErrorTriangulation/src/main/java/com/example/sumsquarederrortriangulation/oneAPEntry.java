package com.example.sumsquarederrortriangulation;

/**
 *wifiAP class can create wifiAP objects, in which we use to store the wifiAPs
 */
public class oneAPEntry {
    private String wifiApName;
    private String macAddress;
    private String signalStrength;

    public oneAPEntry(String wifiApName, String macAddress, String signalStrength) {
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

    public String getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(String signalStrength) {
        this.signalStrength = signalStrength;
    }
}
