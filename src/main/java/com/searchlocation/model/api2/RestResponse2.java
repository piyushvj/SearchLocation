package com.searchlocation.model.api2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class RestResponse2 {
    @JsonProperty
    ArrayList<Object> messages = new ArrayList<Object>();
    @JsonProperty
    ArrayList<Object> result = new ArrayList<Object>();

    public ArrayList<Object> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Object> messages) {
        this.messages = messages;
    }

    public ArrayList<Object> getResult() {
        return result;
    }

    public void setResult(ArrayList<Object> result) {
        this.result = result;
    }
}