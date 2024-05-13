package chap04.p7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlantPriorityQueue {
    private List<Plant> list;

    public PlantPriorityQueue() {
        this.list = new ArrayList<>();
    }

    public void offer(Plant plant) {
        this.list.add(plant);
        Collections.sort(list);
    }

    public Plant poll() {
        Plant poll = this.list.get(0);
        list.remove(0);
        return poll;
    }

    public Plant peek(Plant plant) {
        return this.list.get(0);
    }

    public void clear() {
        System.out.println("Queue clear.");
        this.list.clear();
    }

    public void remove(Plant plant) {
        System.out.println("Queue remove");
        this.list.remove(plant);
    }
}
