package com.titip.model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titip.dto.Response;
import com.titip.model.Enetity.Booking;
import com.titip.model.Enetity.Locker;
import com.titip.model.Enetity.User;
import com.titip.model.Repo.BookingRepository;
import com.titip.model.Repo.LockerRepository;
import com.titip.model.Repo.UserRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private LockerRepository lockerRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Response<Object> createBooking(Long userId, List<Long> lockerIds, LocalDateTime endDate) {
        Response<Object> res = new Response<>();

        if (lockerIds.size() > 3) {
            res.setMessage("Cannot book more than 3 lockers.");
            res.setStatus(HttpStatus.BAD_REQUEST.toString());
            return res;
        }

        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            res.setMessage("User not found.");
            res.setStatus(HttpStatus.NOT_FOUND.toString());
            return res;
        }

        LocalDateTime startDate = LocalDateTime.now();
        long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
        if (totalDays <= 0) {
            res.setMessage("End date must be after the start date.");
            res.setStatus(HttpStatus.BAD_REQUEST.toString());
            return res;
        }

        double deposit = lockerIds.size() * 10000.0 * totalDays;

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setDeposit(deposit);
        booking.setPasswordUsageCount(0);
        booking.setReturned(false);

        for (Long lockerId : lockerIds) {
            Locker locker = lockerRepository.findById(lockerId).orElse(null);
            if (locker == null) {
                res.setMessage("Locker not found.");
                res.setStatus(HttpStatus.NOT_FOUND.toString());
                return res;
            }
            if (locker.isOccupied()) {
                res.setMessage("Locker is already occupied.");
                res.setStatus(HttpStatus.BAD_REQUEST.toString());
                return res;
            }
            locker.setOccupied(true);
            locker.setPassword(generatePassword());
            lockerRepository.save(locker);

            booking.setLocker(locker);
        }

        bookingRepository.save(booking);

        res.setMessage("Success");
        res.setStatus(HttpStatus.OK.toString());
        res.setPayload("Loker berhasil di booking.");
        return res;
    }

    public static String generatePassword() {
        Random random = new Random();
        int password = 1000 + random.nextInt(9000); // Generate a random number between 1000 and 9999
        return String.valueOf(password);
    }
}
