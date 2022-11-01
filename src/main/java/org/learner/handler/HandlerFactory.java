package org.learner.handler;

import org.learner.parser.ParsedRequest;

public class HandlerFactory {

    // routes based on path
    public static BaseHandler getHandler(ParsedRequest request){

        switch (request.getPath()){
            case "/createMessage": return new CreateMessage();
            case "/createUser": return new CreateUsers();
            case "/getMessages": return new GetMessages();
            case "/getUsers": return new GetUsers();
        }
        return new BadRequest();
    }
}
