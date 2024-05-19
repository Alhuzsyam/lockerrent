package com.titip.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.titip.dto.BookingRequest;
import com.titip.dto.Response;
import com.titip.model.Service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public Response<Object> createBooking(@RequestBody BookingRequest bookingRequest) {
        try {
            return bookingService.createBooking(bookingRequest.getUserId(), bookingRequest.getLockerIds(), bookingRequest.getEndDate());
        } catch (Exception e) {
            e.printStackTrace();
            Response<Object> errorResponse = new Response<>();
            errorResponse.setMessage(e.getMessage());
            errorResponse.setStatus("INTERNAL_SERVER_ERROR");
            return errorResponse;
        }
    }
}
