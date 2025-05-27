package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s4_2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        double[] dp = new double[N];

        dp[0] = arr[0];
        double answer = arr[0];

        for(int i = 1; i < N; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.printf("%.3f\n", answer);
        br.close();
    }
}