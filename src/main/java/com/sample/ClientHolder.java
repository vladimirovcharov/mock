package com.sample;

/**
 * @author evgeniy.shevchenko
 * @version 1.0 2/19/2016
 */

public enum ClientHolder {
    CLIENT_HOLDER;

    private Client client = new Client();

    public void start() {
        if (client.getStatus() == Client.State.OFF) {
            client.start();
        }
    }
}
