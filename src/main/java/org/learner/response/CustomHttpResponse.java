package org.learner.response;

import org.learner.handler.GsonTool;

import java.util.Map;

public class CustomHttpResponse {

    private Map<String, String> headers;

    private String status;

    private String version;

    private RestApiAppResponse body;


    public CustomHttpResponse(Map<String, String> headers, String status, String version, RestApiAppResponse body){
        this.headers = headers;
        this.status = status;
        this.version = version;
        this.body = body;
    }

    @Override
    public String toString(){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(version + " " + status + "\n");
        if (status.compareTo("404 Not Found") == 0){
            return stringBuilder.toString();
        }

        if(!headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                stringBuilder.append(entry.getKey() + ": " + entry.getValue() + "\n\n");
            }
        }
        else
            stringBuilder.append('\n');
//    stringBuilder.append("\n" + GsonTool.gson.toJson(body, RestApiAppResponse.class));
        stringBuilder.append(GsonTool.gson.toJson(body, RestApiAppResponse.class));

        return stringBuilder.toString();

    }

}
