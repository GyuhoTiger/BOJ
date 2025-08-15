package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_17484 {
    static final int max = 1000000000;
    static int N, M;
    static int[][] map;
    static int[][][] dp;
    static int[] dir = {-1, 0, 1}; // 왼쪽 대각선 아래, 아래, 오른쪽 대각선 아래

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M][3]; // dp[row][col][dir]

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                for (int d = 0; d < 3; d++) {
                    dp[i][j][d] = max;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = map[0][j];
            }
        }

        // DP
        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int d = 0; d < 3; d++) { // 현재 방향
                    int prevC = c - dir[d]; // 이전 열
                    if (prevC < 0 || prevC >= M) {
                        continue; // 범위 밖
                    }
                    for (int prevDir = 0; prevDir < 3; prevDir++) {
                        if (prevDir == d) continue; // 같은 방향 연속 금지
                        dp[r][c][d] = Math.min(dp[r][c][d], dp[r - 1][prevC][prevDir] + map[r][c]);
                    }
                }
            }
        }

        // 마지막 행 최소값 찾기
        int answer = max;
        for (int c = 0; c < M; c++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[N - 1][c][d]);
            }
        }

        System.out.println(answer);
        br.close();
    }
}