package org.learner.handler;

import org.learner.dao.UserDao;
import org.learner.dto.UserDto;
import org.learner.parser.ParsedRequest;
import org.learner.response.CustomHttpResponse;
import org.learner.response.ResponseBuilder;
import org.learner.response.RestApiAppResponse;

import java.util.ArrayList;
import java.util.List;

public class CreateUsers implements BaseHandler {
    @Override
    public CustomHttpResponse handleRequest(ParsedRequest request) {
        System.out.println("here is how the body looks like:  " + request.getBody());

        UserDao userDao = UserDao.getInstance();
        UserDto newUser = GsonTool.gson.fromJson(request.getBody(),UserDto.class);
        newUser.setUniqueId(String.valueOf(Math.random()));

        ResponseBuilder builder = new ResponseBuilder();
        builder  = builder.setStatus("200 OK");
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(newUser);
        userDao.put(newUser);
        RestApiAppResponse restApiAppResponse = new RestApiAppResponse(true,userDtoList,"");
        builder.setBody(restApiAppResponse);

        return builder.build();
    }
}
