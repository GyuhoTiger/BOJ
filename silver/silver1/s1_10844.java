package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1_10844 {
    static int mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        // dp[자릿수][마지막 자리 수]
        int[][] dp = new int[N + 1][10]; 

        // 한 자리 수는 1 ~ 9만 가능하므로
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1; 
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                // 끝 자리가 0인 경우 -> 앞자리 수는 1만 가능
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % mod;
                }
                // 끝 자리가 9인 경우 -> 앞자리 수는 8만 가능
                else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % mod;
                // 끝 자리가 j인 경우 -> 앞자리 수는 (j -1), (j + 1)만 가능
                } else { 
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                } 
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[N][i]) % mod;
        }

        System.out.println(sum);
        br.close();
    }
}