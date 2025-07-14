package bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2_6359 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 방의 개수 N
            boolean[] arr = new boolean[N + 1];

            for (int j = 1; j <= N; j++) {
                for (int k = j; k <= N; k += j) {
                    arr[k] = !arr[k];
                }
            }

            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (arr[j]) {
                    count++;
                }
            }

            System.out.println(count);
        }
        br.close();
    }
}