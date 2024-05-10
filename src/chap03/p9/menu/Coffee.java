package chap03.p9.menu;

public class Coffee extends Menu {

    private String coffeeBeans;
    private String size;

    public Coffee(String name, int price, String coffeeBeans) {
        super(name, price);
        this.coffeeBeans = coffeeBeans;
    }

    public Coffee(String name, int price, String coffeeBeans, String size) {
        super(name, price);
        this.coffeeBeans = coffeeBeans;
        this.size = size;
    }

    @Override
    public String displayInfo() {
        return this.coffeeBeans + " : " + this.price + "원";
    }

    public String getCoffeeBeans() {
        return coffeeBeans;
    }

    public String getSize() {
        return size;
    }
}
