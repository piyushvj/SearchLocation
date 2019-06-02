package com.searchlocation.model.api2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Application2 {
        @JsonProperty
        RestResponse2 RestResponse;

        // Getter Methods

        public RestResponse2 getRestResponse() {
            return RestResponse;
        }

        // Setter Methods

        public void setRestResponse( RestResponse2 RestResponseObject ) {
            this.RestResponse = RestResponseObject;
        }
}
