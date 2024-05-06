package chap03.p3;

public class Animal extends Organism {

    private String digestion;
    private String food;

    public Animal(String name, String species, String habitat, String digestion, String food) {
        super(name, species, habitat);
        this.digestion = digestion;
        this.food = food;
    }

    @Override
    public String displayInfo() {
        return this.name + ", " + species + ", " + habitat + ", " + digestion + ", " + food;
    }
}
