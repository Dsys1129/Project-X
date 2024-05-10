package chap03.p8;

import chap03.p8.member.Member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Session {

    private Member creator;
    private SessionStatus status;
    private String place;
    private LocalDateTime date;
    private List<Member> memberList = new ArrayList<>();

    public Session(Member creator, SessionStatus status, String place, LocalDateTime date) {
        this.creator = creator;
        this.status = status;
        this.place = place;
        this.date = date;
    }

    public void addMember(Member member) {
        memberList.add(member);
        System.out.println(member.getName() + "이 연습 세션에 참가합니다.");
    }

    public Member getCreator() {
        return creator;
    }

    public String getPlace() {
        return place;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void updateSessionStatus(SessionStatus sessionStatus) {
        this.status = sessionStatus;
    }

    public void updateSessionDate(LocalDateTime date) {
        this.date = date;
    }
}
