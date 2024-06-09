package com.vitabiodome07;

import java.time.LocalDateTime;

public class Visitor {
    private String IpAddr;
    private int visitCount;
    private LocalDateTime lastVisitedDate;

    public Visitor(String ipAddr) {
        IpAddr = ipAddr;
        this.visitCount = 0;
        this.lastVisitedDate = LocalDateTime.now();
    }

    public void increaseVisitCount() {
        this.visitCount += 1;
        this.lastVisitedDate = LocalDateTime.now();
    }

    public int getVisitCount() {
        return visitCount;
    }

    public boolean isFirstVisit() {
        return visitCount == 0;
    }

    public boolean isValidVisit() {
        return lastVisitedDate.plusMinutes(1).isBefore(LocalDateTime.now());
    }
}
