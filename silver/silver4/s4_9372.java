package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs
public class s4_9372 {
    static int T, N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 국가 수
            M = Integer.parseInt(st.nextToken()); // 비행기 종류


            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<Integer>());
            }


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int answer = bfs();
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];

        queue.add(1);
        visited[1] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            int currentPlane = queue.poll();
            for(int nextPlane : graph.get(currentPlane)) {
                if(!visited[nextPlane]) {
                    visited[nextPlane] = true;
                    queue.add(nextPlane);
                    count++;
                }
            }
        }

        return count;
    }
}

// 이 문제 참고로 항상 최소 (N - 1)개의 비행기가 필요해서 그냥 (N - 1)출력해도 됨...