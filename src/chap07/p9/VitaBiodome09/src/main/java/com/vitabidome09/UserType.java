package com.vitabidome09;

public enum UserType {
    ADMIN("관리자"),
    USER("사용자");

    String desc;

    UserType(String desc) {
        this.desc = desc;
    }
}
