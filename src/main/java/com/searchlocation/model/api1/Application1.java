package com.searchlocation.model.api1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Application1 {
    @JsonProperty
    private RestResponse1 RestResponse;
    // Getter Methods
    public RestResponse1 getRestResponse1() {
        return RestResponse;
    }
    // Setter Methods
    public void setRestResponse1(RestResponse1 restResponse) {
        this.RestResponse = restResponse;
    }
}