package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 길이가 n인 이친수의 개수
        long[] dp = new long[N + 1];

        dp[1] = 1;
        
        if (N >= 2) {
            dp[2] = 1;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N]);
        br.close();
    }
}
