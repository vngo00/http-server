package org.learner.handler;

import org.learner.dao.UserDao;
import org.learner.parser.ParsedRequest;
import org.learner.response.CustomHttpResponse;
import org.learner.response.ResponseBuilder;
import org.learner.response.RestApiAppResponse;

public class GetUsers implements BaseHandler {
    @Override
    public CustomHttpResponse handleRequest(ParsedRequest request) {
        UserDao userDao = UserDao.getInstance();

        ResponseBuilder builder = new ResponseBuilder();
        builder.setStatus("200 OK");

        RestApiAppResponse restApiAppResponse = new RestApiAppResponse(true,userDao.getAll(),"");
        builder.setBody(restApiAppResponse);
        return builder.build();
    }
}
