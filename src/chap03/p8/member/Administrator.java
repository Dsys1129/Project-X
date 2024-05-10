package chap03.p8.member;

import chap03.p8.Session;
import chap03.p8.SessionStatus;

import java.time.LocalDateTime;

import static chap03.p8.Formatter.*;

public class Administrator extends Member implements SessionCreatable, SessionDeletable, SessionPostponable{

    public Administrator(String name, LocalDateTime joinDate) {
        super(name, joinDate);
        this.type = MemberType.ADMIN;
    }

    public Administrator(String name, LocalDateTime joinDate, String skillLevel) {
        super(name, joinDate, skillLevel);
        this.type = MemberType.ADMIN;
    }

    @Override
    public Session createSession(String place, LocalDateTime sessionDate) {
        Session session = new Session(this, SessionStatus.CREATED, place, sessionDate);
        session.getMemberList().add(this);
        this.club.addSession(session);
        return session;
    }

    @Override
    public void deleteSession(Session session) {
        if (session.getStatus() == SessionStatus.CANCELED) {
            System.out.println("이미 종료된 연습 세션입니다.");
            return;
        }

        session.updateSessionStatus(SessionStatus.CANCELED);
        System.out.println(formatLocalDateTime(session.getDate()) + ", "
                + session.getPlace() +"에 연습 세션이 취소되었습니다.");
    }

    @Override
    public void postponeSession(Session session, LocalDateTime newDate) {
        if (session.getStatus() == SessionStatus.CANCELED) {
            System.out.println("이미 종료된 연습 세션입니다.");
            return;
        }

        session.updateSessionDate(newDate);
        System.out.println(this.name + "이 " + formatLocalDateTime(session.getDate()) + ", "
                + session.getPlace() +"에 연습 세션을 연기했습니다.");
    }

    public void approveParticipation(OtherAreaMember otherAreaMember, Session session) {
        System.out.println("운영진 " + this.name + "이 타지역 멤버인 "+ otherAreaMember.getName() + "의 연습 세션 참가 요청을 승인하였습니다.");
        session.addMember(otherAreaMember);
    }
}
