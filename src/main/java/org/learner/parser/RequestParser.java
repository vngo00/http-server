package org.learner.parser;

public class RequestParser {

    // extract usable values from http request string
    public static ParsedRequest parse(String request){
        ParsedRequest parsedRequest = new ParsedRequest();

        processHead(parsedRequest,request);

        String body =getBody(request);
        parsedRequest.setBody(body);

        return parsedRequest;
    }



    private static void processHead(ParsedRequest parsedRequest, String request) {
        String head = getHead(request);
        int start = 0;

        for (int i = 0; i < head.length(); i++) {
            // find the method in the head string
            if (head.charAt(i) == ' ') {
                parsedRequest.setMethod(head.substring(start, i));
                start = i + 1;
                break;
            }
        }
        for (int i = start; i < head.length(); i++) {
            // get the path
            if (head.charAt(i) == ' ' || head.charAt(i) == '?') {
                parsedRequest.setPath(head.substring(start, i));

                start = i + 1;
                break;
            }
        }


        for(int i = start; i < head.length(); i++){

            if (head.charAt(i) == ' '){
                handleParams(parsedRequest, head.substring(start, i+1));
                break;
            }
        }
    }


    private static void handleParams(ParsedRequest parsedRequest, String params){
        String key = "";
        String value = "";
        int start = 0;
        for (int i = 0; i < params.length(); i++){
            if (params.charAt(i) == '='){
                key = params.substring(start, i);
                start = i +1;
            }

            if (params.charAt(i) == '&' || i == params.length() -1){
                value = params.substring(start, i);
                start = i + 1;
                parsedRequest.setQueryParam(key, value);
            }

        }

    }

    private static String getHead(String request){
        for(int i = 0 ; i < request.length(); i++){
            if (request.charAt(i) == '\n'){
                return request.substring(0,i-1);
            }
        }
        return "";
    }

    private static String getBody(String request){
//        System.out.println("length of request: " + request.length());
//        System.out.println("here the body:\n\n");


        for(int i =0; i < request.length(); i++){
//          if(request.charAt(i) == '{'){
            if(request.charAt(i) == '\r' && request.charAt(i-1) == '\n' && request.charAt(i+1) == '\n'){
               // System.out.println("length of the body: " + (request.length() - i));
                return request.substring(i+2, request.length());
            }
        }
        return "";
    }
}

