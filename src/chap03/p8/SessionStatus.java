package chap03.p8;

public enum SessionStatus {
    CREATED("개설"),
    CANCELED("취소");

    private String desc;

    SessionStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}

