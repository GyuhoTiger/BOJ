package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 퇴사까지 남은 날짜 N

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] dp = new int[N + 2]; // dp[i] : i일 됐을 때 얻을 수 있는 최대 이익

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int day = 1;
        int max = 0; // 지금까지의 최대 이익
        
        while (day <= N + 1) {
            max = Math.max(max, dp[day]);
        
            // 상담 가능한 경우
            int nextDay = day + T[day];
            if (nextDay <= N + 1) {
                dp[nextDay] = Math.max(dp[nextDay], max + P[day]);
            }
            day++;
        }

        System.out.println(max);
        br.close();
    }
}