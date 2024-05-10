package chap03.p9;

import chap03.p9.menu.*;
import chap03.p9.order.Order;
import chap03.p9.order.OrderItem;

import java.time.LocalDateTime;

public class BiodomeFamily09 {
    public static void main(String[] args) {
        Coffee coffee1 = new Coffee("블렌드 커피", 4000, "블렌드");
        Coffee coffee2 = new Coffee("다크 커피", 4500, "다크");
        Coffee coffee3 = new Coffee("디카페인 커피", 4200, "디카페인");
        Beverage beverage1 = new Beverage("캐모마일", 3000);
        Beverage beverage2 = new Beverage("오렌지 쥬스", 3500);
        Beverage beverage3 = new Beverage("물", 1000);
        Sandwich sandwich1 = new Sandwich("야채 샌드위치", 5000, "야채", LocalDateTime.of(2123,10, 10, 00,00,00));
        Sandwich sandwich2 = new Sandwich("햄 샌드위치", 6000, "햄", LocalDateTime.of(2123,10, 11, 00,00,00));
        Sandwich sandwich3 = new Sandwich("치즈 샌드위치", 5500, "치즈", LocalDateTime.of(2122,01, 06, 00,00,00));

        Caffe caffe = new Caffe();
        caffe.addMenu(coffee1);
        caffe.addMenu(coffee2);
        caffe.addMenu(coffee3);
        caffe.addMenu(beverage1);
        caffe.addMenu(beverage2);
        caffe.addMenu(beverage3);
        caffe.addMenu(sandwich1);
        caffe.addMenu(sandwich2);
        caffe.addMenu(sandwich3);

        System.out.println();

        Order order1 = new Order("제이미", LocalDateTime.of(2123,10,07,14,05,32));
        OrderItem orderItem1 = new OrderItem(new Coffee(coffee1.getName(), coffee1.getPrice(), coffee1.getCoffeeBeans(), "톨"), 2);
        order1.addOrderMenu(orderItem1);
        OrderItem orderItem2 = new OrderItem(new Sandwich(sandwich1.getName(), sandwich1.getPrice(), sandwich1.getIngredients(), sandwich1.getExpirationDate()));
        order1.addOrderMenu(orderItem2);
        caffe.addOrder(order1);

        System.out.println();

        Order order2 = new Order("레냐", LocalDateTime.of(2123, 10, 07, 14, 06, 15));
        OrderItem orderItem3 = new OrderItem(new Beverage("캐모마일", 3000, "톨"));
        order2.addOrderMenu(orderItem3);
        caffe.addOrder(order2);

        System.out.println();

        Order order3 = new Order("오류", LocalDateTime.of(2122,01,07,00,00,00));
        OrderItem orderItem4 = new OrderItem(new Sandwich(sandwich3.getName(), sandwich3.getPrice(), sandwich3.getIngredients(), sandwich3.getExpirationDate()));
        order3.addOrderMenu(orderItem4);
        caffe.addOrder(order3);

        System.out.println();
        caffe.printAllOrders();

        System.out.println("================== Bonus 주문 취소 (레냐, 캐모마일) (없는 이름, 없는 이름) =================");
        caffe.cancelOrder("레냐", "캐모마일");
        caffe.cancelOrder("없는 이름", "야채 샌드위치");

        System.out.println();
        caffe.printAllOrders();
    }
}
