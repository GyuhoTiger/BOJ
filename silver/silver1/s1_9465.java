package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수 T

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 스티커 개수 N

            int[][] stickers = new int[2][N + 1]; // 스티커 점수
            
            // dp[i][j] = i행 0행 ~ i열 j행까지 스티커를 뗐을 때 얻을 수 있는 최대 점수
            int[][] dp = new int[2][N + 1];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 초깃값
            dp[0][1] = stickers[0][1]; // 위
            dp[1][1] = stickers[1][1]; // 아래

            // 상하좌우가 안되므로 항상 대각선 방향으로 1칸이나 2칸 내에서 점수를 획득해야함
            for (int j = 2; j <= N; j++) {

                // 위쪽
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];

                // 아래쪽
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
        br.close();
    }
}