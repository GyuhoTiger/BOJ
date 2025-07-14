package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s2_17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // true : 소수 아님
        boolean[] prime = new boolean[1000001];

        // 에라토스테네스의 체
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    prime[j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            // 반만 확인 -> (1, 2) = (2, 1) 이므로
            for (int j = 2; j <= N / 2; j++) {
                if (!prime[j] && !prime[N - j]) {
                    count++;
                }
            }

            System.out.println(count);
        }
        
        br.close();
    }
}