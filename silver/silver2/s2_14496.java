package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_14496 {
    static int N, M;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // 바꾸려는 대상 a
        int b = Integer.parseInt(st.nextToken()); // 바꾸려는 결과 b

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 전체 문자의 수 N
        M = Integer.parseInt(st.nextToken()); // 치환 가능한 문자쌍의 수 M

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        System.out.println(bfs(a, b));
        br.close();
    }

    static int bfs(int start, int end) {
        int[] arr = new int[N + 1];
        Arrays.fill(arr, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        arr[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (arr[next] == -1) {
                    arr[next] = arr[cur] + 1;
                    q.add(next);
                }
            }
        }
        return arr[end];
    }
}