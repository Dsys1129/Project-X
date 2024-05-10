package chap03.p8.member;

import chap03.p8.Session;

import java.time.LocalDateTime;

public class OtherAreaMember extends Member{

    public OtherAreaMember(String name, LocalDateTime joinDate, String skillLevel, String region) {
        super(name, joinDate, skillLevel, region);
        this.type = MemberType.OTHER_AREA_MEMBER;
    }

    @Override
    public void joinSession(Session session) {
        System.out.println(this.name + "회원은 타지역 멤버이기 때문에 운영진의 승인이 필요합니다. 승인을 신청합니다.");
    }
}
