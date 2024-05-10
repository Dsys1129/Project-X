package chap03.p8;

import chap03.p8.member.Member;

import java.util.ArrayList;
import java.util.List;

import static chap03.p8.Formatter.formatLocalDateTime;

public class Club {

    private List<Member> memberList = new ArrayList<>();
    private List<Session> sessionList = new ArrayList<>();

    public void addMember(Member member) {
        System.out.println(member.getName() + "이 " + member.getType().getDesc() + "으로 가입되었습니다.");
        memberList.add(member);
        member.joinClub(this);
    }

    public void addSession(Session session) {
        System.out.println(session.getCreator().getName() + "이 "
                + formatLocalDateTime(session.getDate()) + ", " +session.getPlace()+ "에 연습 세션을 오픈했습니다.");
        sessionList.add(session);
    }

    public void searchSessionBy(SessionStatus sessionStatus) {
        for (Session session : sessionList) {
            if (session.getStatus() == sessionStatus) {
                List<Member> membmerList = session.getMemberList();
                String joinMembers = "";
                for (Member member : membmerList) {
                    joinMembers += member.getName() + " ";
                }
                joinMembers = joinMembers.trim();
                System.out.println(formatLocalDateTime(session.getDate()) + ", " + session.getPlace() +", " + "[" + joinMembers + "], " +
                        session.getCreator().getName() + ", " + session.getStatus().getDesc());
            }
        }
    }
}
