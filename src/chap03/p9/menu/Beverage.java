package chap03.p9.menu;

public class Beverage extends Menu{

    private String size;

    public Beverage(String name, int price) {
        super(name, price);
    }

    @Override
    public String displayInfo() {
        return this.name + " : " + this.price + "원";
    }

    public Beverage(String name, int price, String size) {
        super(name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
