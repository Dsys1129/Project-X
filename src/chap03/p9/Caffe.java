package chap03.p9;

import chap03.p9.menu.Menu;
import chap03.p9.order.Order;
import chap03.p9.order.OrderItem;
import chap03.p9.order.OrderList;
import chap03.p9.order.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class Caffe {

    private List<Menu> menuList = new ArrayList<>();
    private OrderList orderList = new OrderList();

    public void addMenu(Menu menu) {
        this.menuList.add(menu);
        System.out.println(menu.displayInfo());
    }

    public void addOrder(Order order) {
        if (!order.checkValidOrder()) {
            return;
        }
        order.updateOrderStatus(OrderStatus.ORDER_COMPLETED);
        this.orderList.addOrder(order);

        System.out.println("=================== 주문이 추가되었습니다.==================");
        order.printOrder(order);

        System.out.println("--------------------------------------------------------");
    }

    public void printAllOrders() {
        int index = 1;
        for (Order order : orderList.getOrderQueue()) {
            if (order.getOrderStatus() != OrderStatus.CANCELED && order.getOrderStatus() != OrderStatus.COMPLETED) {
                System.out.println("주문" + index + ".");
                order.printOrder(order);
                System.out.println();
                index++;
            }
        }
    }

    public void cancelOrder(String orderer, String menuName) {
        for (Order order : this.orderList.getOrderQueue()) {
            if (order.getOrderer().equals(orderer)) {
                if (order.getOrderStatus() == OrderStatus.ORDER_COMPLETED) {
                    for (OrderItem orderItem : order.getOrderItemList()) {
                        if (orderItem.getMenu().getName().equals(menuName)) {
                            order.updateOrderStatus(OrderStatus.CANCELED);
                            System.out.println("주문을 취소하였습니다.");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("주문을 취소할 수 없습니다.");
    }
}
