package com.titip.model.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.titip.model.Enetity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
   Booking findByid(Long id);

     @Query("SELECT b FROM Booking b WHERE b.locker.id = :lockerId")
    Booking findByLockerId(@Param("lockerId") Long lockerId);
}

