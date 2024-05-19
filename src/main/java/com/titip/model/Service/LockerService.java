package com.titip.model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titip.model.Enetity.Locker;
import com.titip.model.Repo.LockerRepository;

@Service
public class LockerService {
    @Autowired
    private LockerRepository lockerRepository;

    public Locker createLocker(Locker locker) {
        return lockerRepository.save(locker);
    }
    public Locker getLockerById(Long id) {
        return lockerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Locker not found with id: " + id));
    }
}
