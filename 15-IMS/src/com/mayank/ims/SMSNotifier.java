package com.mayank.ims;

public class SMSNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending to number " + message);
    }
}
