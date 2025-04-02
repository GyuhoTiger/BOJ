package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_5014 {
    static int F, S, G, U, D;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 총 F층짜리 건물
        S = Integer.parseInt(st.nextToken()); // 현재 위치한 층
        G = Integer.parseInt(st.nextToken()); // 목표 층
        U = Integer.parseInt(st.nextToken()); // 위로 U층
        D = Integer.parseInt(st.nextToken()); // 아래로 D층

        visited = new boolean[F + 1];

        bfs();

        br.close();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;

        int count = 0; // 버튼 누르는 횟수

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if (now == G) {
                    System.out.println(count);
                    return;
                }
    
                // 위
                int up = now + U;
                if (up <= F && !visited[up]) {
                    visited[up] = true;
                    queue.add(up);
                }
    
                // 아래
                int down = now - D;
                if (down >= 1 && !visited[down]) {
                    visited[down] = true;
                    queue.add(down);
                }
            }
            count++;
        }
        System.out.println("use the stairs"); 
    }
}
