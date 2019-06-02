package com.searchlocation.model.api1;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class RestResponse1 {
    @JsonProperty
    ArrayList<Object> messages = new ArrayList<Object>();

    @JsonProperty
    Result ResultObject;

    public ArrayList<Object> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Object> messages) {
        this.messages = messages;
    }

    public Result getResult() {
        return ResultObject;
    }

    public void setResult( Result resultObject ) {
        this.ResultObject = resultObject;
    }
}