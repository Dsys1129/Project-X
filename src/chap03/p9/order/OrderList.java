package chap03.p9.order;

import java.util.LinkedList;
import java.util.Queue;

public class OrderList {

    private Queue<Order> orderQueue = new LinkedList<>();

    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }

    public void addOrder(Order order) {
        this.orderQueue.offer(order);
    }

    public void removeOrder(Order order) {
        this.orderQueue.remove(order);
    }
}
