package org.learner.handler;

import org.learner.dao.MessageDao;
import org.learner.dto.MessageDto;
import org.learner.parser.ParsedRequest;
import org.learner.response.CustomHttpResponse;
import org.learner.response.ResponseBuilder;
import org.learner.response.RestApiAppResponse;

import java.util.ArrayList;
import java.util.List;

public class GetMessages implements BaseHandler {
    @Override
    public CustomHttpResponse handleRequest(ParsedRequest request) {
        String fromId = request.getQueryParam("fromId");
        String toId = request.getQueryParam("toId");


        List<MessageDto> messageDtoList = new ArrayList<>();

        MessageDao messageDao = MessageDao.getInstance();

        for (MessageDto temp : messageDao.getAll()){
            if(temp.getFromId().compareTo(fromId) == 0 && temp.getToId().compareTo(toId) == 0){
                messageDtoList.add(temp);
            }
        }

        ResponseBuilder builder = new ResponseBuilder();
        builder.setStatus("200 OK");

        RestApiAppResponse restApiAppResponse = new RestApiAppResponse(true,messageDtoList,"");
        builder.setBody(restApiAppResponse);
        return builder.build();
    }
}
