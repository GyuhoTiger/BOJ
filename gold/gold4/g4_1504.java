package gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class g4_1504 {
    static int N, E;
    static List<int[]>[] graph; // 노드와 간선 쌍을 저장하기 위해 int 배열을 리스트로 구현
    static final int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 개수 N
        int E = Integer.parseInt(st.nextToken()); // 간선 개수 E
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()); // 반드시 거쳐야하는 정점 v1
        int v2 = Integer.parseInt(st.nextToken()); // 반드시 거쳐야하는 정점 v2

        // 가만 생각해보니까 v1, v2를 모두 거치는 최단 경로를 구해야하므로 다익스트라 구간을 나눈걸 2번 계산해서 최솟값을 찾아야함
        int case1 = dijkstra(1, v2) + dijkstra(v1, v2) + dijkstra(v2, N);
        int case2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        int result = Math.min(case1, case2);

        if (result >= max) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

        br.close();
    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, max); // 노드간 거리를 모두 최대치로 설정
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        return dist[end];
    }
}