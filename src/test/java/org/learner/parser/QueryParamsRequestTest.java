package org.learner.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QueryParamsRequestTest {
    @Test
    public void testGetParams(){
        String randomKey = String.valueOf(Math.random());
        String randomValue = String.valueOf(Math.random());
        String test1 = "GET /hello/world?" + randomKey + "=" + randomValue + " HTTP/1.1\n";
        ParsedRequest request = RequestParser.parse(test1);
        Assert.assertEquals(request.getPath(), "/hello/world");
        Assert.assertEquals(request.getQueryParam(randomKey), randomValue);
    }
}
