package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s2_15988 {
    static int MOD = 1000000009; // 문제에서 주어진 나누는 숫자
    static int MAX = 1000000; // N의 최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[MAX + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int T = Integer.parseInt(br.readLine());

        // 점화식 계산
        for (int i = 4; i <= MAX; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
