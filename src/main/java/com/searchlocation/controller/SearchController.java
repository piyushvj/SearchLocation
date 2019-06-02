package com.searchlocation.controller;

import com.searchlocation.model.CustomResponse;
import com.searchlocation.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * This is a main controller class for search mechanism.
 *
 * @author  Piyush Vijayvargiya
 * @version 1.0
 * @since   2019-June-02
 */

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public ResponseEntity<CustomResponse> searchLocation(@RequestParam("state") String state) {

        ResponseEntity<CustomResponse> responseEntity;
        CustomResponse customResponse = new CustomResponse();
        if(!StringUtils.isEmpty(state)) {
            customResponse = searchService.searchState(state);
            if (!StringUtils.isEmpty(customResponse.getMessage())) {
                responseEntity = new ResponseEntity<>(customResponse, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
            }
        }else{
            customResponse.setMessage("Please provide state code");
            responseEntity = new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}