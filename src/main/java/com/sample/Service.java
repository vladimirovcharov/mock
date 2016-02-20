package com.sample;

public class Service {
    public void startClient() {
        Client client = new Client();
        if (client.getStatus() == Client.State.OFF) {
            client.start();
        }
    }
}
