package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1_3896 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final int MAX = 1299709; // 100000번째 소수
        boolean[] prime = new boolean[MAX + 1];

        // 에라토스테네스의 체
        for (int i = 2; i <= MAX; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (prime[i] == true) {
                for (int j = (i * i); j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            if (prime[k]) {
                System.out.println(0);
                continue;
            }

            int left = k - 1;
            while (left >= 2 && !prime[left]) {
                left--;
            }

            int right = k + 1;
            while (right <= MAX && !prime[right]) {
                right++;
            }

            System.out.println(right - left);
        }

        br.close();
    }
}