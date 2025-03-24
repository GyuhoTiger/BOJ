package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP
public class s2_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N]; // 증가 부분 수열 합 저장배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
        }

        int answer = dp[0];

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] < arr[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + arr[j]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
        br.close();     
    }
}
