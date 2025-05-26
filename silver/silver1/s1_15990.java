package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1_15990 {
    static final int mod = 1000000009;
    static final int max = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;

        // dp[N][M]: 정수 N을 1, 2, 3의 합으로 나타내는 방법의 수(M은 끝자리 숫자)
        long [][] dp = new long[max + 1][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= max; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
        }

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 T

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            answer = (dp[N][1] + dp[N][2] + dp[N][3]) % mod;
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}