package com.example.cse_javasync_samplecode;

public class Counter {
    int count;

    public synchronized void increment(){
        count = count + 1;
    }
}
