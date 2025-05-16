package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_10451 {
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visit = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int k = 1; k <= N; k++) {
                if (!visit[k]) {
                    dfs(k);
                    count++;
                }
            }

            System.out.println(count);
        }
        br.close();
    }

    public static void dfs(int node) {
        if (visit[node]) {
            return;
        }
        visit[node] = true;
        dfs(arr[node]);
    }
}