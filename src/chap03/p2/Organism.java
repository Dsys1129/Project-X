package chap03.p2;

public class Organism {

    private String name;
    private String species;
    private String habitat;
    private String characteristic;
    private String lifeSpan;

    public Organism(String name, String species, String habitat) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
    }

    public Organism(String name, String species, String habitat, String characteristic, String lifeSpan) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.characteristic = characteristic;
        this.lifeSpan = lifeSpan;
    }

    public String displayInfo() {
        return name + ", " + species + ", " + habitat;
    }

    public String displayInfoWithCharacteristicAndLifeSpan() {
        return name + ", " + species + ", " + habitat + ", " + characteristic + ", " + lifeSpan;
    }

    // setter와 동일
    public void updateHabitat(String habitat) {
        System.out.println(this.name + "의 서식지 변경 : " + this.habitat + " -> " + habitat);
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

    public String getCharacteristic() {
        return characteristic;
    }

    public void updateCharacteristic(String characteristic) {
        System.out.println(this.name + "의 특징 변경 : " + this.characteristic + " -> " + characteristic);
        this.characteristic = characteristic;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }
}
