package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g5_9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 편의점 수
            int V = N + 2; // 집 + 편의점들 + 페스티벌
            ArrayList<int[]> list = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new int[]{x, y});
            }

            System.out.println(bfs(list, V) ? "happy" : "sad");
        }
    }

    static boolean bfs(ArrayList<int[]> list, int V) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[V];

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] pos = list.get(cur);

            // 페스티벌 도착
            if (cur == V - 1) {
                return true;
            }

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    int[] next = list.get(i);
                    int dist = Math.abs(pos[0] - next[0]) + Math.abs(pos[1] - next[1]);
                    if (dist <= 1000) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
        return false;
    }
}