package chap02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RoadToBiodome10 {
    private static int[][] relations;
    private static boolean[] visited;

    public static void main(String[] args) {
        System.out.println("입력 : " + Arrays.toString(args));
        String[] split = args[0].split(" ");
        relations = new int[101][101];
        visited = new boolean[101];

        for (String input : split) {
            String[] relation = input.split(",");
            if (!isNumbers(relation)) {
                System.out.println("입력값은 숫자여야 합니다");
                return;
            }

            int from = Integer.parseInt(relation[0]);
            int to = Integer.parseInt(relation[1]);

            if (!isValidNumber(from) || !isValidNumber(from)) {
                System.out.println("가능한 수의 범위를 벗어났습니다.");
                return;
            }
            relations[from][to] = 1;
            relations[to][from] = 1;
        }

        // DFS
        int count = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101 ; j++) {
                if (!visited[i] && relations[i][j] == 1) {
                    dfs(i);
                    count++;
                }
            }
        }
        System.out.println("기본 문제 출력 >>> " + count);

        // Bonus
        // BFS
        visited = new boolean[101];
        int bonusCount = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (!visited[i] && relations[i][j] == 1) {
                    bfs(i);
                    bonusCount++;
                }
            }
        }
        System.out.println("보너스 문제 (BFS) 출력 >>> " + bonusCount);
    }

    private static void dfs(int to) {
        if (visited[to]) {
            return;
        }

        visited[to] = true;
        for (int i = 1; i < 101; i++) {
            if (relations[to][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <101; i++) {
                if (!visited[i] && relations[current][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    private static boolean isValidNumber(int number) {
        return number >= 1 && number <=100;
    }

    private static boolean isNumbers(String[] strings) {
        for (String s : strings) {
            for (char c : s.toCharArray()) {
                if (c < '0' || c > '9') {
                    return false;
                }
            }
        }
        return true;
    }
}
