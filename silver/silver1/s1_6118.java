package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_6118 {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] distance;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 헛간 수 N
        int M = Integer.parseInt(st.nextToken()); // 양방향 길 수 M

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        distance = new int[N + 1];
        visit = new boolean[N + 1];

        // 1번 헛간부터 BFS
        bfs(1);

        int number = 0;
        int max = 0;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (distance[i] > max) {
                max = distance[i];
                number = i;
                count = 1;
            } else if (distance[i] == max) {
                number = Math.min(number, i);
                count++;
            }
        }

        System.out.println(number + " " + max + " " + count);
        br.close();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (!visit[next]) {
                    visit[next] = true;
                    distance[next] = distance[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}