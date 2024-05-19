package com.titip.model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.titip.dto.Response;
import com.titip.model.Enetity.Booking;
import com.titip.model.Enetity.Locker;
import com.titip.model.Repo.BookingRepository;
import com.titip.model.Repo.LockerRepository;

@Service
public class LockerReturnService {

    @Autowired
    private LockerRepository lockerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Response<Object> returnItem(String password, Long lockerId) {
        Response<Object> res = new Response<>();

        Locker locker = lockerRepository.findByPassword(password);

        if(locker == null || !locker.getId().equals(lockerId)) {
            res.setStatus(HttpStatus.BAD_REQUEST.toString());
            res.setMessage("Incorrect password or locker ID.");
            return res;
        }

        Booking booking = bookingRepository.findByLockerId(lockerId);

        if(booking == null) {
            res.setStatus(HttpStatus.BAD_REQUEST.toString());
            res.setMessage("Booking for the given locker ID does not exist.");
            return res;
        }

        booking.setFine(1);
        booking.setReturned(true);
        locker.setOccupied(false);

        lockerRepository.save(locker);
        bookingRepository.save(booking);

        res.setStatus(HttpStatus.OK.toString());
        res.setMessage("Locker successfully returned and updated.");
        return res;
    }
}
