package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_1788 {
    public static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N < 0 && Math.abs(N) % 2 == 0) {
            System.out.println(-1);
        } else if (N == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

        N = Math.abs(N);
        long[] arr = new long[1000001];

        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % MOD;
        }

        System.out.println(arr[N]);
        br.close();
    }
}