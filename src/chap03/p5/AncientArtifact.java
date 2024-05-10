package chap03.p5;

abstract class AncientArtifact {

    protected final String name;

    public AncientArtifact(String name) {
        this.name = name;
        System.out.println(this.name + " 유물이 생성되었습니다.");
    }

    public abstract void describe();

    public String getName() {
        return this.name;
    }
}
