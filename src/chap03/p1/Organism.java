package chap03.p1;

public class Organism {

    private String name;
    private String species;
    private String habitat;

    public Organism(String name, String species, String habitat) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
    }

    public String displayInfo() {
        return name + ", " + species + ", " + habitat;
    }

    public void updateHabitat(String habitat) {
        System.out.println("서식지 변경 : " + this.habitat + " -> " + habitat);
        this.habitat = habitat;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getHabitat() {
        return habitat;
    }
}
