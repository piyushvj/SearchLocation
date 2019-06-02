package com.searchlocation.helper;

import com.searchlocation.model.CustomResponse;
import com.searchlocation.model.api1.Application1;
import com.searchlocation.util.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import org.junit.Assert;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class SearchHelperTest {

    @InjectMocks
    private SearchHelper searchHelper;

    @Mock
    RestTemplate restTemplate;


    @Test
    public void prepareUrlTest_whenNullUrl(){
        String url = searchHelper.prepareUrl("", "UP");
        //Assert.isNull(url,"SHOULD BE NULL");
    }

    @Test
    public void prepareUrlTest_whenSuccess(){
        String url = searchHelper.prepareUrl("ABC_URL_", "UP");
        Assert.assertEquals("ABC_URL_UP", url);
    }

    @Test
    public void callApiTest(){
        when(restTemplate.getForObject("ABC", Application1.class)).thenReturn(TestData.prepareApi1Response());
        Application1 application = searchHelper.callApi("ABC", Application1.class);
        Assert.assertNotNull(application);
    }

    @Test
    public void createCustomResponseTest(){
        CustomResponse customResponse = searchHelper.createCustomResponse(TestData.prepareResponseList());
        Assert.assertNotNull(customResponse.getMessage());
    }


}
