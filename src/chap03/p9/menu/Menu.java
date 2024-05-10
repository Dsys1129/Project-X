package chap03.p9.menu;

public abstract class Menu {
    protected String name;
    protected int price;

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract String displayInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
}
