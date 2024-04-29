package chap02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RoadToBiodome09 {

    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    private static int N;
    private static int M;
    private static int[][] distance;

    public static void main(String[] args) {
        System.out.println("입력 : " + Arrays.toString(args));
        if (args.length < 1) {
            System.out.println("값을 입력해주세요");
            return;
        }

        if (args.length < 2) {
            System.out.println("이차원 배열이 아닙니다.");
            return;
        }

        N = args.length;
        M = args[0].length();
        map = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];

        for (int i = 0; i < args.length; i++) {
            String row = args[i];
            if (!row.matches("^[0-2]*$")) {
                System.out.println("입력값은 0 또는 1 (보너스) 2만 가능합니다");
                return;
            }

            for (int j = 0; j < args[0].length(); j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        if (distance[N - 1][M - 1] == 0) {
            System.out.println("안전한 경로가 없습니다");
        } else {
            System.out.println(distance[N - 1][M - 1]);
        }
    }

    private static void BFS(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < dy.length; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx] && map[ny][nx] == 1) {
                    queue.offer(new int[] {ny, nx});
                    visited[ny][nx] = true;
                    distance[ny][nx] = distance[current[0]][current[1]] + 1;
                }
            }
        }
    }
}
