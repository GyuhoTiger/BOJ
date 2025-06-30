package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4_10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int maxSum = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = j; k < N; k++) {
                    sum += arr[k];
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
            System.out.println(maxSum);
        }
        br.close();
    }
}