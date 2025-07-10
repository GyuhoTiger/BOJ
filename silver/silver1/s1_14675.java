package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s1_14675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 정점 수 N
        ArrayList<Integer>[] list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 정점 u
            int v = Integer.parseInt(st.nextToken()); // 정점 v

            list[u].add(v);
            list[v].add(u);
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (t == 1) {
                // 연결된 정점이 2개 이상이면 단절점
                if (list[k].size() >= 2) sb.append("yes").append("\n");
                else sb.append("no\n");
            } else {
                // 트리는 모든 간선이 단절선
                sb.append("yes").append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}