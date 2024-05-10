package chap03.p8.member;

public enum MemberType {

    ADMIN("운영진"),
    REGULAR("일반 멤버"),
    NEW("신규 멤버"),
    OTHER_AREA_MEMBER("타지역 멤버");

    private String desc;

    MemberType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
