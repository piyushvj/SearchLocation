package com.searchlocation.service;

import com.searchlocation.helper.SearchHelper;
import com.searchlocation.model.api2.Application2;
import com.searchlocation.model.CustomResponse;
import com.searchlocation.model.api1.Application1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a service class which provide services to search mechanism.
 *
 * @author  Piyush Vijayvargiya
 * @version 1.0
 * @since   2019-June-02
 */

@Service
public class SearchService {

    @Autowired
    private SearchHelper searchHelper;

    @Value("${api1.url}")
    private String api1; // api1 : it searches state based on state code like UP for Utter-Pradesh


    @Value("${api2.url}")
    private String api2; //// api2 : it searches state if state name contains given text like Pradesh will return 5 state namely Madhy-Pradesh, Uttar-Pradesh etc.

    public CustomResponse searchState(String stateCode ){

        if(StringUtils.isEmpty(api1) || StringUtils.isEmpty(api2)){
            return new CustomResponse();
        }

        List<Object> responseList = new ArrayList<>();

        Application1 response1 = searchHelper.callApi(searchHelper.prepareUrl(api1,stateCode), Application1.class);
        responseList.add(response1);

        Application2 response2 = searchHelper.callApi(searchHelper.prepareUrl(api2,stateCode), Application2.class);
        responseList.add(response2);

        CustomResponse customResponse = searchHelper.createCustomResponse(responseList);

        return customResponse;
    }
}