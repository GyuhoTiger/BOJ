package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_32712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long max = 0;
        long sum = 0;

        long min = Math.min(N, K);

        // 시계방향
        for (int i = 0; i < min; i++) {
            max = Math.max(max, sum + (K - i) * arr[i]);
            sum += arr[i];
        }

        // 반시계방향
        sum = 0;
        for (int i = 0; i < min; i++) {
            max = Math.max(max, sum + (K - i) * arr[N - 1 - i]);
            sum += arr[N - 1 - i];
        }

        System.out.println(max);
        br.close();
    }
}