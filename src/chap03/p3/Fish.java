package chap03.p3;

public class Fish extends Animal {

    private String finsCount;

    public Fish(String name, String species, String habitat, String digestion, String food, String finsCount) {
        super(name, species, habitat, digestion, food);
        this.finsCount = finsCount;
    }

    public void swim() {
        System.out.println(this.name + " : " + "Swimming");
    }
}
