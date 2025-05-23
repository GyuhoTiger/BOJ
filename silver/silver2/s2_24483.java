package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class s2_24483 {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int count = 1;
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 수 N
        M = Integer.parseInt(st.nextToken()); // 간선의 수 M
        R = Integer.parseInt(st.nextToken()); // 시작 정점 R

        graph = new ArrayList[N + 1];
        visited = new int[N + 1];

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

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R, 0);

        System.out.print(result);
        br.close();
    }

    public static void dfs(int node, int depth) {
        visited[node] = count;

        // (long) 안써서 틀렸습니다 떴음 ㅎ
        result += (long) depth * count;
        count++;

        for (int next : graph[node]) {
            if (visited[next] == 0) {
                dfs(next, depth + 1);
            }
        }
    }
}