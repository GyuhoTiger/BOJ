package bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1_2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int prev = 0;

        for (int i = 0; i < 10; i++) {
            int mushroom = Integer.parseInt(br.readLine());

            sum += mushroom;

            if (sum >= 100) {
                // 100에 더 가까운 누적 점수를 출력
                if (sum - 100 <= 100 - prev) {
                    System.out.println(sum);
                } else {
                    System.out.println(prev);
                }
                return;
            }
            prev = sum;
        }

        System.out.println(sum);
        br.close();
    }
}