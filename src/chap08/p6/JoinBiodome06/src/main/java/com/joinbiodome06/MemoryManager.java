package com.joinbiodome06;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryManager {

    private Runtime runtime;
    private List<GarbageCollectorMXBean> gcBeans;
    private List<MemoryHistory> memoryHistoryList;
    private static final int MAX_MEMORY_HISTORY_LENGTH = 10;

    public MemoryManager() {
        runtime = Runtime.getRuntime();
        gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        memoryHistoryList = new ArrayList<>();
    }

    public int getAvailableProcessors() {
        return runtime.availableProcessors();
    }

    public Map<String, Double> getMemoryUsage() {
        Map<String, Double> memoryUsage = new HashMap<>();
        double totalMemory = runtime.totalMemory() / (1024.0 * 1024.0);
        double freeMemory = runtime.freeMemory() / (1024.0 * 1024.0);
        double usedMemory = totalMemory - freeMemory;

        memoryUsage.put("totalMemory", Math.round(totalMemory * 100.0) / 100.0);
        memoryUsage.put("usedMemory", Math.round(usedMemory * 100.0) / 100.0);
        memoryUsage.put("freeMemory", Math.round(freeMemory * 100.0) / 100.0);

        recordMemoryHistory(Math.round(usedMemory * 100.0) / 100.0);
        return memoryUsage;
    }

    public long getGcCount() {
        long gcCount = 0;
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            gcCount += gcBean.getCollectionCount();
        }
        return gcCount;
    }

    private void recordMemoryHistory(double usedMemory) {
        if (memoryHistoryList.size() >= MAX_MEMORY_HISTORY_LENGTH) {
            memoryHistoryList.remove(0);
        }
        memoryHistoryList.add(new MemoryHistory(LocalDateTime.now(), usedMemory));
    }

    public List<MemoryHistory> getMemoryHistoryList() {
        return memoryHistoryList;
    }
}
