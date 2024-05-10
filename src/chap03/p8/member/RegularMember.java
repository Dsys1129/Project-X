package chap03.p8.member;

import chap03.p8.Session;
import chap03.p8.SessionStatus;

import java.time.LocalDateTime;

public class RegularMember extends Member implements SessionCreatable{
    public RegularMember(String name, LocalDateTime date) {
        super(name, date);
        this.type = MemberType.REGULAR;
    }

    public RegularMember(String name, LocalDateTime joinDate, String skillLevel) {
        super(name, joinDate, skillLevel);
        this.type = MemberType.REGULAR;
    }

    @Override
    public Session createSession(String place, LocalDateTime sessionDate) {
        Session session = new Session(this, SessionStatus.CREATED, place, sessionDate);
        session.getMemberList().add(this);
        club.addSession(session);
        return session;
    }
}
