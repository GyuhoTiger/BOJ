package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s2_9020 {
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

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수 T
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 정수(짝수) N

            // 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력 -> 중앙부터 시작
            for (int j = N / 2; j >= 2; j--) {
                if (!prime[j] && !prime[N - j]) {
                    System.out.println(j + " " + (N - j));
                    break;
                }
            }
        }
    }
}