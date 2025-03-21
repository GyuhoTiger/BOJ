package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP
public class s2_11060 {
    static int MAX = 1001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = MAX;
        }

        dp[1] = 0;

        for (int i = 1; i <= N; i++) {
            if (dp[i] >= MAX) continue;
            for (int j = i + 1; j <= i + arr[i]; j++) {
                if (j > N) break;
                dp[j] = Math.min(dp[j], dp[i] + 1); // 현재 점프와 이전까지 점프 비교
            }
        }

        if (dp[N] >= MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
        br.close();
    }
}
