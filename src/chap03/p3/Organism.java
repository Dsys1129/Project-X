package chap03.p3;

public class Organism {
    protected String name;
    protected String species;
    protected String habitat;

    public Organism(String name, String species, String habitat) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
    }

    public String displayInfo() {
        return name + ", " + species + ", " + habitat;
    }

    public String getName() {
        return name;
    }

}
