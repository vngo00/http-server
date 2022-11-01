package org.learner.handler;

import org.learner.parser.ParsedRequest;
import org.learner.response.CustomHttpResponse;
import org.learner.response.ResponseBuilder;

public class BadRequest implements BaseHandler{
    @Override
    public CustomHttpResponse handleRequest(ParsedRequest parsedRequest){
        ResponseBuilder responseBuilder = new ResponseBuilder();
        responseBuilder.setStatus("404 Not Found");
        return responseBuilder.build();
    }
}
