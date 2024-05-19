package com.titip.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.titip.dto.Response;
import com.titip.dto.ReturnRequest;
import com.titip.model.Service.LockerReturnService;

@RestController
public class LockerReturnController {

    @Autowired
    private LockerReturnService lockerReturnService;

    @PostMapping("/api/return")
    public Response<Object> returnItem(@RequestBody ReturnRequest returnRequest) {
       try{
            return lockerReturnService.returnItem(returnRequest.getPassword(),returnRequest.getLockerId());
       } catch(Exception e){
        e.printStackTrace();
        Response<Object> errorResponse = new Response<>();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus("INTERNAL_SERVER_ERROR");
        return errorResponse;
       }
    }
}
