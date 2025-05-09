package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs
public class s1_11403 {
    static int N;
    static int[][] graph;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }

    static void bfs(int start) {
        boolean[] visit = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next = 0; next < N; next++) {
                if (graph[now][next] == 1 && visit[next] == false) {
                    visit[next] = true;
                    result[start][next] = 1;
                    queue.offer(next);
                }
            }
        }
    }
}
