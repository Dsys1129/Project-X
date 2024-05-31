package chap06.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RunBiodome01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("멤버 리스트를 입력하세요:");
        String input = br.readLine();

        String[] members = input.replaceAll("[\\[\\],]", "").split(" ");

        List<String> newMembers = Arrays.stream(members).filter(member -> member.startsWith("신입-"))
                .map(member -> member.replaceAll("신입-", "") + "님 환영합니다")
                .collect(Collectors.toList());

        System.out.println(newMembers);

        System.out.println("\n=================== Bonus ==================");
        String[] bonusMembers = {"신입-하브", "멤버-세이지", "신입-아마라", "운영진-아이샤", "신입-미호",
                "멤버-하린", "멤버-캐머린", "운영진-리즈키", "신입-라스코", "신입-제레드"};

        Map<String, List<String>> groupedMembers = Arrays.stream(bonusMembers)
                .filter(member -> member.startsWith("신입-") || member.startsWith("멤버-"))
                .collect(Collectors.groupingBy(member -> member.startsWith("신입-") ? "신입 멤버" : "일반 멤버",
                        Collectors.mapping(member -> member.split("-")[1], Collectors.toList())));

        System.out.println("신입 멤버 : " + groupedMembers.get("신입 멤버"));
        System.out.println("일반 멤버 : " + groupedMembers.get("일반 멤버"));
    }
}
