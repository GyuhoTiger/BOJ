package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_11051 {
    static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][N + 1]; // i개 중 j개를 고르는 경우의 수

        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1; // nC0 = nCn = 1
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD; // 이항 계수 성질을 이용한 점화식
                }
            }
        }

        System.out.println(dp[N][K]);
        br.close();
    }
}