package com.adu.sun.misc;

import sun.misc.Signal;
import sun.misc.SignalHandler;

@SuppressWarnings("restriction")
public class TestSignal implements SignalHandler {

    @Override
    public void handle(Signal signal) {
        System.out.println(signal.getName() + "is recevied.");
    }

    public static void main(String[] args) throws InterruptedException {
        TestSignal testSignalHandler = new TestSignal();
        // install signals
        Signal.handle(new Signal("TERM"), testSignalHandler);
        Signal.handle(new Signal("USR2"), testSignalHandler);
        for (;;) {
            Thread.sleep(3000);
            System.out.println("running......");
        }
    }

}
