package com.titip.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BookingRequest {
    private Long userId;
    private List<Long> lockerIds;
    private LocalDateTime endDate;

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getLockerIds() {
        return lockerIds;
    }

    public void setLockerIds(List<Long> lockerIds) {
        this.lockerIds = lockerIds;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
