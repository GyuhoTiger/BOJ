package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s4_13699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] t = new long[N + 1];

        t[0] = 1;

        for(int i = 1; i < N + 1; i++) {
            for (int j = 0; j < i; j++) {
                t[i] += t[j] * t[i - 1 - j];
            }
        }

        System.out.println(t[N]);
        br.close();
    }
}