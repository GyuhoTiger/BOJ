package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// dfs
public class s2_24479 {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int order = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[N + 1];
        visited = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // 오름차순 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(visited[i] == -1) {
                sb.append(0).append("\n"); // 방문안한 경우 -> 0
            } else {
                sb.append(visited[i]).append("\n"); // 방문한 경우 -> 순서
            }
        }
        System.out.print(sb.toString());
        br.close();
    }

    public static void dfs(int root) {
        visited[root] = order++; // 방문 순서

        for(int node : graph[root]) {
            if(visited[node] == -1) {
                dfs(node);
            }
        }
    }
}