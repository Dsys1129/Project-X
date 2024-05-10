package chap03.p8.member;

import java.time.LocalDateTime;

public class NewMember extends Member {
    public NewMember(String name, LocalDateTime joinDate) {
        super(name, joinDate);
        this.type = MemberType.NEW;
    }

    public NewMember(String name, LocalDateTime joinDate, String skillLevel) {
        super(name, joinDate, skillLevel);
        this.type = MemberType.NEW;
    }
}
