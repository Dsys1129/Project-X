package chap03.p8.member;

import chap03.p8.Session;

import java.time.LocalDateTime;

public interface SessionPostponable {

    void postponeSession(Session session, LocalDateTime newDate);
}
