package com.searchlocation.service;

import com.searchlocation.helper.SearchHelper;
import com.searchlocation.model.CustomResponse;
import com.searchlocation.model.api1.Application1;
import com.searchlocation.util.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

    @InjectMocks
    private SearchService searchService;

    @Mock
    private SearchHelper searchHelper;

    @Mock
    private RestTemplate restTemplate;

    private static final String API1 ="http://services.groupkt.com/state/get/IND/";
    private static final String API2 ="http://services.groupkt.com/state/search/IND?text=";
    private static final String STATE_CODE="UP";

    @Test
    public void searchStateTest_whenApiNotConfigured(){
        CustomResponse customResponse = searchService.searchState("UP");
        Assert.isNull(customResponse.getMessage(), "NO MESSAGE");
    }


    @Test
    public void searchStateTest(){
        ReflectionTestUtils.setField(searchService, "api1",API1);
        ReflectionTestUtils.setField(searchService, "api2",API2);
        when(searchHelper.prepareUrl(API1,"UP")).thenReturn(API1+"UP");
        when(searchHelper.callApi(API1+"UP", Application1.class)).thenReturn(TestData.prepareApi1Response());
        CustomResponse customResponse = searchService.searchState("UP");
        Assert.isNull(customResponse,"");
    }

}
