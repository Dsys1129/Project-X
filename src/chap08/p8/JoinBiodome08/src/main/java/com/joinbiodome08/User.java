package com.joinbiodome08;

public class User {
    private String name;
    private int point;

    public User(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void increasePoint(int point) {
        if (point < 1) {
            throw new UserPointException("1 이상의 양수값을 입력해주세요");
        }

        if (this.point + point > 50) {
            throw new UserPointException("포인트는 50을 넘을 수 없습니다.");
        }
        this.point += point;
    }

    public void decreasePoint(int point) {
        if (point < 1) {
            throw new UserPointException("1 이상의 양수값을 입력해주세요");
        }

        if (this.point - point < 0) {
            throw new UserPointException("포인트는 음수일 수 없습니다.");
        }
        this.point -= point;
    }
}
