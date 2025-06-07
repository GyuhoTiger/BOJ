package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] wine = new int[N + 1];
        int[] dp = new int[N + 1]; // i번째 포도주까지 마셨을 때 최대 양

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(wine[1]);
            return;
        }

        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        // 1. i번째 잔을 안마심 | 2. i번째만 마시고 (i - 1)번째는 안마심 | 3. i번째만 마시고 (i - 1)번째 마시고 (i - 2)번째는 안마심
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[N]);
        br.close();
    }
}