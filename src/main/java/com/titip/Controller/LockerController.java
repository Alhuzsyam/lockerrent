package com.titip.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.titip.model.Enetity.Locker;
import com.titip.model.Service.LockerService;

@RestController
@RequestMapping("/api/lockers")
public class LockerController {
    @Autowired
    private LockerService lockerService;

    @PostMapping
    public Locker createLocker(@RequestBody Locker locker) {
        return lockerService.createLocker(locker);
    }
}
