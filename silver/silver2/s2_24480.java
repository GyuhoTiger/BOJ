package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class s2_24480 {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] arr;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 수 N
        M = Integer.parseInt(st.nextToken()); // 간선의 수 M
        R = Integer.parseInt(st.nextToken()); // 시작 정점 R


        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static void dfs(int r) {
        visit[r] = true;
        arr[r] = count++;

        for (int next : graph[r]) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }
}