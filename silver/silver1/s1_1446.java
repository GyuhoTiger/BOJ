package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지름길의 개수 N
        int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이 D

        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작
            arr[i][1] = Integer.parseInt(st.nextToken()); // 끝
            arr[i][2] = Integer.parseInt(st.nextToken()); // 길이
        }

        
        int[] dp = new int[D + 1];
        // 기본: 직선 도로만 간 경우
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            for (int j = 0; j < N; j++) {
                int start = arr[j][0];
                int end = arr[j][1];
                int len = arr[j][2];

                if (start == i && end <= D) {
                    dp[end] = Math.min(dp[end], dp[start] + len);
                }
            }
        }

        System.out.println(dp[D]);
        br.close();
    }
}