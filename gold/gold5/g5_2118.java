package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class g5_2118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arr[i] += arr[i - 1];
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = (i + 1); j < N; j++) {

                int forward = Math.abs(arr[j] - arr[i]);
                int backward = arr[N] - forward;

                int dist = Math.min(forward, backward);

                answer = Math.max(answer,dist);
            }
        }

        System.out.println(answer);
        br.close();
    }
}