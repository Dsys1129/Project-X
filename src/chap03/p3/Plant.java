package chap03.p3;

public class Plant extends Organism{

    private String floweringTime;
    private String fruit;

    public Plant(String name, String species, String habitat, String floweringTime, String fruit) {
        super(name, species, habitat);
        this.floweringTime = floweringTime;
        this.fruit = fruit;
    }

    @Override
    public String displayInfo() {
        return name + ", " + species + ", " + habitat + ", " + floweringTime + ", " + fruit;
    }
}
