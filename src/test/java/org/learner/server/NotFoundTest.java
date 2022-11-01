package org.learner.server;

import org.junit.Assert;
import org.junit.Test;

public class NotFoundTest {

    @Test
    public void do404(){
        String test1 ="GET /something HTTP/1.1\n"
                + "\n";

        String response = Server.processRequest(test1);
        Assert.assertEquals(response, "HTTP/1.1 404 Not Found\n");
    }
}
