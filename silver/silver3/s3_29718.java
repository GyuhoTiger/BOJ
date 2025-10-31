package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_29718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행의 개수 N
        int M = Integer.parseInt(st.nextToken()); // 열의 개수 M

        long[] sum = new long[M + 1];

        // 열별로 누적
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                sum[j] += Long.parseLong(st.nextToken());
            }
        }

        int A = Integer.parseInt(br.readLine()); // 연속 열의 개수 A

        // 누적합 배열
        long[] arr = new long[M + 1];
        for (int j = 1; j <= M; j++) {
            arr[j] = arr[j - 1] + sum[j];
        }

        long max = 0;
        for (int j = A; j <= M; j++) {
            long result = arr[j] - arr[j - A];
            if (result > max) {
                max = result;
            }
        }

        System.out.println(max);
        br.close();
    }
}