package chap04.p2.user;

public enum UserType {
    MANAGER("관리자"),
    MEMBER("이용자"),
    STUDENT("학생");

    String desc;

    UserType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
