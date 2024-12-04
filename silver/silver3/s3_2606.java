package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class s3_2606 {
    static int number; // 컴퓨터 개수(노드)
    static int connection; // 연결되어 있는 컴퓨터 쌍의 수(간선)
    static boolean[] visited;
    static List<Integer>[] array; // 인접 리스트
    static int count; // 감염된 컴퓨터 개수수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());
        connection = Integer.parseInt(br.readLine());
        visited = new boolean[number + 1];
        array = new ArrayList[number + 1];

        for (int i = 1; i <= number; i++) {
            array[i] = new ArrayList<>(); // 리스트 초기화
        }

        StringTokenizer st;
        for(int i = 0; i < connection; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // 컴퓨터 n - 컴퓨터 m 쌍방 연결
            array[n].add(m);
            array[m].add(n);
        }

        System.out.println(bfs(1)); // 1번 컴퓨터부터 시작
        br.close();
    }

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(start); // 1번 컴퓨터 추가
        visited[start] = true; // 1번 컴퓨터 방문

        while(!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < array[temp].size(); i++) { // 현재 노드와 연결된 노드 모두 탐색
                int neighbor = array[temp].get(i); // 현재 컴퓨터와 연결된 컴퓨터 get
                if (!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                    count++;
                }
            }
        }
        return count; 
    }
}
