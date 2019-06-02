package com.searchlocation.controller;

import com.searchlocation.model.CustomResponse;
import com.searchlocation.service.SearchService;
import com.searchlocation.util.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {
    
    @InjectMocks
    private SearchController searchController;

    @Mock
    private SearchService searchService;

    @Test
    public void searchLocation_whenStateNotGiven(){
        ResponseEntity<CustomResponse> responseEntity = searchController.searchLocation(null);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void searchLocation_whenSuccess(){
        when(searchService.searchState("UP")).thenReturn(TestData.prepareCustomResponse());
        ResponseEntity<CustomResponse> responseEntity = searchController.searchLocation("UP");
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void searchLocation_whenEmptyMessageFromExternalApi(){
        CustomResponse customResponse = TestData.prepareCustomResponse();
        customResponse.setMessage("");
        when(searchService.searchState("UP")).thenReturn(customResponse);
        ResponseEntity<CustomResponse> responseEntity = searchController.searchLocation("UP");
        Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

}
