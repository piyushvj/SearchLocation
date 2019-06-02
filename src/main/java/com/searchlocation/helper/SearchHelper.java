package com.searchlocation.helper;

import com.searchlocation.model.api2.Application2;
import com.searchlocation.model.CustomResponse;
import com.searchlocation.model.api1.Application1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * The SearchHelper program implements useful methods for search mechanism
 *
 * @author  Piyush Vijayvargiya
 * @version 1.0
 * @since   2019-June-02
 */

@Component
public class SearchHelper {

    @Autowired
    RestTemplate restTemplate;

    /**
     * This method is used to prepare URL.
     *
     * @param url predefined url, which is to be modified
     * @param stateCode  state of country which is to be searched
     * @return String This returns complete url to be searched.
     */
    public String prepareUrl(String url, String stateCode){
        if(StringUtils.isEmpty(url) || StringUtils.isEmpty(stateCode))
            return null;

        return url = url+stateCode;
    }

    /**
     * This method is generic to call rest api.
     * and return response object.
     * @param url api which is to be called
     * @param type a class in which api response is to be cast
     * @return T return api response .
     */
    public <T> T callApi(String url, Class<T> type) {

        T response = restTemplate.getForObject(url,type);

        return response;
    }

    /**
     * This method prepares custom object, which is a final object to be returned from this api
     *
     * @param responseList this is a list of response from all the external api call     *
     * @return Final custom response which was prepared from the response of different api call.
     */
    public CustomResponse createCustomResponse(List<Object> responseList){
        // custom response object
        CustomResponse customResponse = new CustomResponse();

        // preparing custom response message
        StringBuilder customMessage = new StringBuilder();

        // work on each api response
        for(Object response : responseList) {
            // getting message from first API
            if(response instanceof Application1){
                Application1 application1 = (Application1)response;
                String message1 = (String)application1.getRestResponse1().getMessages().get(0);
                customMessage.append(message1);
            }

            // getting message from second API
            if(response instanceof Application2){
                Application2 application2 = (Application2)response;
                String message2 = (String)application2.getRestResponse().getMessages().get(0);
                customMessage.append(" And there are total ");
                customMessage.append(message2);
            }
        }
        // custom message prepared
        if(customMessage.length()!=0){
            customResponse.setMessage(customMessage.toString());
        }

        return customResponse;
    }
}
