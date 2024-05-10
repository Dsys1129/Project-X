package chap03.p8;

import chap03.p8.member.*;

import java.time.LocalDateTime;

public class BiodomeFamily08 {

    public static void main(String[] args) {
        Club club = new Club();
        Administrator john = new Administrator("John", LocalDateTime.now());
        RegularMember jane = new RegularMember("Jane", LocalDateTime.now());
        RegularMember doe = new RegularMember("Doe", LocalDateTime.now());
        NewMember amy = new NewMember("Amy", LocalDateTime.now());
        NewMember leo = new NewMember("Leo", LocalDateTime.now());

        club.addMember(john);
        club.addMember(jane);
        club.addMember(doe);
        club.addMember(amy);
        club.addMember(leo);

        Session createdSession = john.createSession("도메 스타디움", LocalDateTime.now());
        System.out.println();

        jane.joinSession(createdSession);
        amy.joinSession(createdSession);

        club.searchSessionBy(SessionStatus.CREATED);

        john.postponeSession(createdSession, createdSession.getDate().plusDays(7));

        john.deleteSession(createdSession);

        club.searchSessionBy(SessionStatus.CANCELED);

        System.out.println("\n=============== Bonus =================");

        Session bonusCreatedSession = john.createSession("도메 스타디움", LocalDateTime.now());
        OtherAreaMember otherAreaMember = new OtherAreaMember("타지역", LocalDateTime.now(), "초급", "타지역");
        club.addMember(otherAreaMember);
        otherAreaMember.joinSession(bonusCreatedSession);

        john.approveParticipation(otherAreaMember, bonusCreatedSession);
        club.searchSessionBy(SessionStatus.CREATED);
    }
}
