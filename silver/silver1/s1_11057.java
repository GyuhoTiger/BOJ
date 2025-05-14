package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_11057 {
    static final int mod = 10007;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // [자리 수][마지막 자리 숫자] -> 오르막 수
        int[][] dp = new int[N + 1][10];

        // N = 1인 경우 초기값 설정
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}

        // dp[i][j] = dp[i - 1][0] + dp[i - 1][1] + ... + dp[i - 1][j]
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                }
            }
        }

        // 누적합 방식
        // for(int i = 2; i <= N; i++) {
        //     dp[i][0] = 1; // 끝 자리가 0인 수는 모두 오르막 수가 1
        //     for(int j = 0; j < 10; j++) {
        //         dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
        //     }
        // }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum % mod);
        br.close();
    }
}