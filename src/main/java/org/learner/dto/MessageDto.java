package org.learner.dto;

import java.time.Instant;

public class MessageDto extends BaseDto{
    private String fromId;

    private String toId;

    private String message;

    private long timeStamp;



    public MessageDto(){
        timeStamp = Instant.now().toEpochMilli();
    }


    public MessageDto(String uniqueId){
        super(uniqueId);
        timeStamp = Instant.now().toEpochMilli();
    }

    public String getFromId() {
        return fromId;
    }

    public String getToId() {
        return toId;
    }

    public String getMessage() {
        return message;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
