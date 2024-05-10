package chap03.p8.member;

import chap03.p8.Session;

import java.time.LocalDateTime;

public interface SessionCreatable {

    Session createSession(String place, LocalDateTime sessionDate);
}
