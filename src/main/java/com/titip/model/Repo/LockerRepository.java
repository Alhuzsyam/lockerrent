package com.titip.model.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titip.model.Enetity.Locker;

public interface LockerRepository extends JpaRepository<Locker, Long> {
    Locker findByPassword(String password);
}

