package com.joinbiodome06;

import java.time.LocalDateTime;

public class MemoryHistory {

    private LocalDateTime localDateTime;
    private double usedMemory;

    public MemoryHistory(LocalDateTime localDateTime, double usedMemory) {
        this.localDateTime = localDateTime;
        this.usedMemory = usedMemory;
    }
}
