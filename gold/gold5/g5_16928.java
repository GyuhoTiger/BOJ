package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g5_16928 {
    static int[] board = new int[101]; // 1 ~ 100번까지의 게임칸
    static int[] visited = new int[101]; // 방문 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리의 수 N
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수 M

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        bfs();

        System.out.println(visited[100]);
        br.close();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100) continue;
                if (visited[next] != 0 || next == 1) continue;

                // 사다리나 뱀 있으면 이동
                if (board[next] != 0) {
                    next = board[next];
                }

                // 아직 방문 안 한 곳이면
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}