package com.titip.model.Enetity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isReturned;
    private double deposit;
    private double fine;
    private int passwordUsageCount;

    // Getters and setters
}
