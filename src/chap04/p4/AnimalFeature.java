package chap04.p4;

public class AnimalFeature {
    private String behavior;
    private String reproductionMethod;
    private int averageLifespan;

    public AnimalFeature(String behavior, String reproductionMethod, int averageLifespan) {
        this.behavior = behavior;
        this.reproductionMethod = reproductionMethod;
        this.averageLifespan = averageLifespan;
    }

    @Override
    public String toString() {
        return behavior + ", " + reproductionMethod + ", " + averageLifespan;
    }
}
