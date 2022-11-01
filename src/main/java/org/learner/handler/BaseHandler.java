package org.learner.handler;

import org.learner.parser.ParsedRequest;
import org.learner.response.CustomHttpResponse;

public interface BaseHandler {

    CustomHttpResponse handleRequest(ParsedRequest request);

}
