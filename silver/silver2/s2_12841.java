package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 누적합
public class s2_12841 {
    static long minValue = Long.MAX_VALUE;
    static int num = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] cross = new long[N + 1];
        long[] left = new long[N];
        long[] right = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cross[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            left[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            right[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            long min = cross[i];
            for (int l = 1; l < i; l++) {
                min += left[l];
            }
            for (int r = i; r < N; r++) {
                min += right[r];
            }
            if (minValue > min) {
                minValue = min;
                num = i;
            }
        }
        sb.append(num).append(' ').append(minValue);

        System.out.println(sb);
        br.close();
    }
}