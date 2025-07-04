package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_1577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 가로
        int M = Integer.parseInt(st.nextToken()); // 세로
        int K = Integer.parseInt(br.readLine());

        // (0,0)부터 (N, M)까지 갈 수 있는 경로의 수 : dp
        long[][] dp = new long[M + 1][N + 1];

        // 막혀있을 때, (X, Y)에서 오른쪽 or 아래로 갈 수 있는지
        // [0] : 오른쪽으로 가는 도로 막힘, [1] : 아래쪽으로 가는 도로가 막힘
        boolean[][][] arr = new boolean[M + 1][N + 1][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == x2) {
                int minY = Math.min(y1, y2);
                arr[minY][x1][1] = true; // 아래쪽으로 막힘
            } else {
                int minX = Math.min(x1, x2);
                arr[y1][minX][0] = true; // 오른쪽으로 막힘
            }
        }

        dp[0][0] = 1;

        for (int y = 0; y <= M; y++) {
            for (int x = 0; x <= N; x++) {
                if (x > 0 && !arr[y][x - 1][0]) {
                    dp[y][x] += dp[y][x - 1]; // 왼쪽에서
                }
                if (y > 0 && !arr[y - 1][x][1]) {
                    dp[y][x] += dp[y - 1][x]; // 위에서
                }
            }
        }

        System.out.println(dp[M][N]);
        br.close();
    }
}