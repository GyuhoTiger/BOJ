package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP
public class s4_10164 {
    private static int N, M, K;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행의 수
        M = Integer.parseInt(st.nextToken()); // 열의 수
        K = Integer.parseInt(st.nextToken()); // O 표시된 칸의 번호

        dp = new int[N][M];

        // K 좌표 계산
        int x = (K - 1) / M;
        int y = (K - 1) % M;

        // K가 없는 경우 : 전체 배열에서 경로 계산
        if(K == 0) {
            System.out.println(route(N, M));
        } else {
            int route1 = route(x + 1, y + 1);
            dp = new int[N][M]; // dp 초기화
            int route2 = route(N - x, M - y);
            System.out.println(route1 * route2);
        }
        br.close();
    }
    private static int route(int x, int y) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
              if(i == 0 || j == 0) {
                dp[i][j] = 1;
              } else {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
              } 
            }
        }
        return dp[x - 1][y - 1];
    }
}
