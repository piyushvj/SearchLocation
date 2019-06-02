package com.searchlocation.util;

import com.searchlocation.model.CustomResponse;
import com.searchlocation.model.api1.Application1;
import com.searchlocation.model.api2.Application2;
import com.searchlocation.model.api2.RestResponse2;
import com.searchlocation.model.api1.RestResponse1;
import com.searchlocation.model.api1.Result;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static Application1 prepareApi1Response(){
        Application1 application1 = new Application1();
        RestResponse1 restResponse1 = new RestResponse1();
        ArrayList<Object> messsages = new ArrayList();
        messsages.add("TestData-Api1");
        restResponse1.setMessages(messsages);

        Result result = new Result();
        result.setName("Uttar-Pradesh");
        result.setLargest_city("Lacknow");
        result.setCountry("IND");
        result.setAbbr("UP");
        result.setArea("199812341SKM");
        result.setId(82);
        restResponse1.setResult(result);

        application1.setRestResponse1(restResponse1);

        return application1;
    }

    public static Application2 prepareApi2Response(){
        Application2 application2 = new Application2();

        RestResponse2 restResponse2 = new RestResponse2();
        //messages
        ArrayList<Object> messages = new ArrayList<>();
        messages.add("TestData-Api2");

        restResponse2.setMessages(messages);
        //result
        ArrayList<Object> resultList = new ArrayList<>();

        Result result1 = new Result();
        result1.setName("Uttar-Pradesh");
        result1.setLargest_city("Lacknow");
        result1.setCountry("IND");
        result1.setAbbr("UP");
        result1.setArea("199812341SKM");
        result1.setId(82);
        resultList.add(result1);

        Result result2 = new Result();
        result2.setName("Madhya Pradesh");
        result2.setLargest_city("Indore");
        result2.setCountry("IND");
        result2.setAbbr("MP");
        result2.setArea("72626809SKM");
        result2.setId(69);
        resultList.add(result2);

        restResponse2.setResult(resultList);
        restResponse2.setMessages(messages);

        application2.setRestResponse(restResponse2);

        return application2;
    }

    public static List<Object> prepareResponseList(){
        List<Object> responseList = new ArrayList<>();
        responseList.add(prepareApi1Response());
        responseList.add(prepareApi2Response());
        return responseList;
    }

    public static CustomResponse prepareCustomResponse(){
        CustomResponse customResponse = new CustomResponse();

        List<Object> responseList = prepareResponseList();

        Application1 applicatoion1 = (Application1)responseList.get(0);
        Application2 applicatoion2 = (Application2)responseList.get(1);

        StringBuilder customMessage = new StringBuilder();
        String message1 = (String) applicatoion1.getRestResponse1().getMessages().get(0);
        String message2 = (String) applicatoion2.getRestResponse().getMessages().get(0);

        customMessage.append(message1).append(" And there are total ").append(message2);

        customResponse.setMessage(customMessage.toString());
        return customResponse;
    }
}
