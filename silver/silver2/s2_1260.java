package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_1260 {
    static int N, M, V;
    static boolean[] visited;
    static List<Integer>[] array;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M =  Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        array = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            array[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            array[X].add(Y);
            array[Y].add(X);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(array[i]);
        }

        dfs(V);
        sb.append('\n');
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
        br.close();
    }

    // dfs : 재귀 이용
    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(' ');
        for(int i = 0; i < array[start].size(); i++) {
            int neighbor = array[start].get(i);
            if(!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    // bfs : 큐 이용
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp).append(' ');
            for (int i = 0; i < array[temp].size(); i++) {
                int neighbor = array[temp].get(i); 
                if (!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
