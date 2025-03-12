package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_18352 {
    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 원하는 거리
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        distance = new int[N + 1];
        
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
            distance[i] = -1;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        bfs();

        boolean check = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                sb.append(i).append("\n");
                check = true;
            }
        }

        if(!check) {
            System.out.print(-1);
        } else {    
            System.out.print(sb);
        }
        br.close();
    }
    
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(X);
        distance[X] = 0;

        while(!queue.isEmpty()) {
            int currentCity = queue.poll();
            for(int nextCity : graph.get(currentCity)) {
                if(distance[nextCity] == -1) {
                    distance[nextCity] = distance[currentCity] + 1;
                    queue.add(nextCity);
                }
            }
        }
    }
}
