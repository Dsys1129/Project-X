package chap03.p6;

public class Animal {

    private String name;
    private String type;
    private int age;

    public Animal(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println(name + " : " + type + " : " + age + "살");
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }
}
