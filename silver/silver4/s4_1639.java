package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s4_1639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();

        // 가장 긴 티켓 번호부터 시작
        for (int i = len; i > 0; i--) {
            // 행운의 티켓은 정확하게 짝수
            if (i % 2 != 0) {
                continue;
            } 
            for (int j = 0; j <= (len - i); j++) {
                int sum1 = 0;
                int sum2 = 0;
                int mid = j + i / 2;

                for (int k = j; k < mid; k++) {
                    sum1 += s.charAt(k) - '0';
                }
                for (int k = mid; k < (j + i); k++) {
                    sum2 += s.charAt(k) - '0';
                }

                // 양쪽 합이 같을 경우 행운 티켓 출력
                if (sum1 == sum2) {
                    System.out.print(i);
                    return;
                }
            }
        }
        System.out.print(0);
        br.close();
    }
}
