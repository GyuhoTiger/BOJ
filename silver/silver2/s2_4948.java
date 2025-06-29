package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s2_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[246913]; // 123456 * 2 = 246913
        
        // 소수 판별(에라토스테네스의 체)
        arr[0] = arr[1] = true;
        for (int i = 2; (i * i) <= 246913; i++) {
            if (!arr[i]) {
                for (int j = (i * i); j <= 246913; j += i) {
                    arr[j] = true;
                }
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            int count = 0;
            for (int i = (N + 1); i <= (2 * N); i++) {
                if (!arr[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}