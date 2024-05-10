package chap03.p8.member;

import chap03.p8.Club;
import chap03.p8.Session;

import java.time.LocalDateTime;

public abstract class Member {

    protected String name;
    protected LocalDateTime joinDate;
    protected String skillLevel;
    protected MemberType type;
    protected Club club;
    protected String region;

    public Member(String name, LocalDateTime joinDate) {
        this.name = name;
        this.joinDate = joinDate;
    }

    public Member(String name, LocalDateTime joinDate, String skillLevel) {
        this.name = name;
        this.joinDate = joinDate;
        this.skillLevel = skillLevel;
    }

    public Member(String name, LocalDateTime joinDate, String skillLevel, String region) {
        this.name = name;
        this.joinDate = joinDate;
        this.skillLevel = skillLevel;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public MemberType getType() {
        return type;
    }

    public void joinClub(Club club) {
        this.club = club;
    }

    public void joinSession(Session session) {
        session.addMember(this);
    }
}
