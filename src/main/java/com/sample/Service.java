package com.sample;

public class Service {
    Client client = new Client();

    public void startClient() {
        if (client.getStatus() == Client.State.OFF) {
            client.start();
        }
    }
}
