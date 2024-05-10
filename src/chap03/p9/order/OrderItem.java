package chap03.p9.order;

import chap03.p9.menu.Menu;

public class OrderItem {

    private Menu menu;
    private int quantity;

    public OrderItem(Menu menu) {
        this.menu = menu;
        this.quantity = 1;
    }

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
