package chap03.p9.order;

public enum OrderStatus {
    BEFORE_ORDER("주문 전"),
    ORDER_COMPLETED("주문 완료"),
    INPROGRESS("제조 중"),
    COMPLETED("완료"),
    CANCELED("취소");

    String desc;

    OrderStatus(String desc) {
        this.desc = desc;
    }
}
