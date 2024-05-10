package chap03.p6;

public class BonusAnimal {

    private String name;
    private AnimalType type;
    private int age;

    public BonusAnimal(String name, AnimalType type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println(name + " : " + type.desc + " : " + age + "살");
    }

    public int getAge() {
        return age;
    }

    public AnimalType getType() {
        return type;
    }
}
