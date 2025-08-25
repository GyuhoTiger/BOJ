package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken()); // 할머니가 넘어온 날 D
        int K = Integer.parseInt(st.nextToken()); // 호랑이에게 준 떡의 개수 K

        int[] arr = new int[D + 1];
        arr[1] = 1; arr[2] = 1;
        for (int i = 3; i <= D; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int A = 1; A <= K; A++) {
            int number = K - arr[D - 2] * A;
            // 정수 확인
            if (number % arr[D - 1] == 0) {
                int B = number / arr[D - 1];
                if (B >= 1) {
                    System.out.println(A);
                    System.out.println(B);
                    return;
                }
            }
        }
        br.close();
    }
}