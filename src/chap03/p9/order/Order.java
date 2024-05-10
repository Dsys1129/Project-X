package chap03.p9.order;

import chap03.p9.menu.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderer;
    private List<OrderItem> orderItemList = new ArrayList<>();
    private LocalDateTime orderDateTime;
    private OrderStatus orderStatus;

    public Order(String orderer, LocalDateTime orderDateTime) {
        this.orderer = orderer;
        this.orderStatus = OrderStatus.BEFORE_ORDER;
        this.orderDateTime = orderDateTime;
    }

    public void addOrderMenu(OrderItem orderItem) {
        this.orderItemList.add(orderItem);
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void printOrder(Order order) {
        int totalPrice = 0;
        System.out.println("고객 : " + orderer);
        System.out.println("주문 시각 : " + orderDateTime);
        for (int i = 1; i <= order.getOrderItemList().size(); i++) {
            OrderItem orderItem = order.getOrderItemList().get(i - 1);
            Menu orderedMenu = orderItem.getMenu();
            int orderItemPrice = calculateOrderItemPrice(orderItem.getQuantity(), orderedMenu.getPrice());
            totalPrice += orderItemPrice;

            if (orderItem.getMenu() instanceof Coffee) {
                System.out.println(i + ") " + orderedMenu.getName() +
                        " (사이즈 : " + ((Coffee) orderedMenu).getSize() + ") - " +
                        orderItem.getQuantity() + "잔 : " + orderItemPrice + "원");
            }

            if (orderedMenu instanceof Beverage) {
                System.out.println(i + ") " + orderedMenu.getName() +
                        " (사이즈 : " + ((Beverage) orderedMenu).getSize() + ") - " +
                        orderItem.getQuantity() + "개 : " + orderItemPrice + "원");
            }

            if (orderedMenu instanceof Sandwich) {
                System.out.println(i + ") " + orderedMenu.getName() +
                        " - " + orderItem.getQuantity() + "개 : " + orderItemPrice + "원");
            }
        }
        System.out.println("총 금액 : " + totalPrice);
    }

    private int calculateOrderItemPrice(int quantity, int price) {
        return quantity * price;
    }

    public boolean checkValidOrder() {
        for (OrderItem orderItem : orderItemList) {
            Menu orderMenu = orderItem.getMenu();
            if (orderMenu instanceof Sandwich) {
                if (((Sandwich) orderMenu).getExpirationDate().isBefore(orderDateTime)) {
                    System.out.println("주문할 수 없는 상품입니다. (만료날짜: " + ((Sandwich) orderMenu).getExpirationDate() +")");
                    return false;
                }
            }
        }
        return true;
    }

    public void updateOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderer() {
        return orderer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
