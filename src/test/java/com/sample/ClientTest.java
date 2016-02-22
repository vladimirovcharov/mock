package com.sample;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author evgeniy.shevchenko
 * @version 1.0 2/19/2016
 */

public class ClientTest {
    @Test
    public void shouldStartOnlyOne() {
        Client client = new Client();
        Client mock = spy(client);
        ClientHolder clientHolder = ClientHolder.CLIENT_HOLDER;
        Whitebox.setInternalState(clientHolder, "client", mock);
        clientHolder.start();
        clientHolder.start();
        clientHolder.start();

        verify(mock, times(1)).start();
    }

    @Test
    public void shouldStartOnlyOne2() {
        Client client = new Client();
        Client mock = spy(client);

        Service service = new Service();
        Whitebox.setInternalState(service, "client", mock);

        service.startClient();
        service.startClient();
        service.startClient();

        verify(mock, times(1)).start();
    }
}
