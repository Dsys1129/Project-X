package chap04.p4;

public class BiologicalEntity<T> {

    private String name;
    private String type;
    private T feature;

    public BiologicalEntity(String name, String type, T feature) {
        this.name = name;
        this.type = type;
        this.feature = feature;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name + ", " + type +  ", " + feature.toString();
    }
}
