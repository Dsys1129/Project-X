package chap04.p4;

public class MicrobeFeature {

    private String livingEnvironment;
    private String metabolism;

    public MicrobeFeature(String livingEnvironment, String metabolism) {
        this.livingEnvironment = livingEnvironment;
        this.metabolism = metabolism;
    }

    @Override
    public String toString() {
        return livingEnvironment +  ", " + metabolism;
    }
}
