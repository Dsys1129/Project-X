package chap03.p3;

public class Bird extends Animal{

    private String wingSpan;

    public Bird(String name, String species, String habitat, String digestion, String food, String wingSpan) {
        super(name, species, habitat, digestion, food);
        this.wingSpan = wingSpan;
    }

    public void fly() {
        System.out.println(this.name + " : " + "flying");
    }
}
