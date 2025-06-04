package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s2_11724 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 수 N
        M = Integer.parseInt(st.nextToken()); // 간선의 수 M

        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }

    static void dfs(int node) {
        visit[node] = true;

        for (int i : graph[node]) {
            if (!visit[i]) {
                dfs(i);
            }
        }
    }
}