package org.learner.dto;

public abstract class BaseDto {

    private String uniqueId;

    public BaseDto(){

    }

    public BaseDto(String uniqueId){
        this.uniqueId = uniqueId;
    }

    public String getUniqueId(){
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
