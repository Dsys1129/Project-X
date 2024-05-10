package chap03.p6;

public enum AnimalType {
    MONKEY("원숭이"),
    TIGER("호랑이"),
    ELEPHANT("코끼리"),
    RHINOCEROS("코뿔소"),
    DEER("사슴"),
    WOLF("늑대");

    String desc;

    AnimalType(String desc) {
        this.desc = desc;
    }
}
