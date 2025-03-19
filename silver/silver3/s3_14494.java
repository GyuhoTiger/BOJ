package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP (Top-Down)
public class s3_14494 {
    static long[][] arr;
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new long[n + 1][m + 1];

        // 계산되지 않은 값들 -1로 초기화
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                arr[i][j] = -1;
            }
        }
        
        System.out.println(dp(n,m));
        br.close();
    }

    static long dp(int n, int m) {
        if (n == 0 || m == 0) return 0;  // 배열 범위 밖은 0
        if (n == 1 || m == 1) return 1;  // 첫 번째 행 or 열은 1
        if (arr[n][m] != -1) return arr[n][m];  // 이미 계산한 값

        arr[n][m] = (dp(n - 1, m) + dp(n, m - 1) + dp(n - 1, m - 1)) % MOD;
        return arr[n][m];
    }
}