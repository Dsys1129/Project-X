package chap03.p3;

public class Mammal extends Animal {

    private String warmBlooded;

    public Mammal(String name, String species, String habitat, String digestion, String food, String warmBlooded) {
        super(name, species, habitat, digestion, food);
        this.warmBlooded = warmBlooded;
    }

    public void giveBirth() {
        System.out.println(this.name + " : " + "give Birth");
    }
}
