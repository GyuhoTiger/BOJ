package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int five = n / 5;  // 5원짜리 동전 최대 개수
        
        while (five >= 0) {
            int two = n - (five * 5);
            if (two % 2 == 0) {
                System.out.println(five + (two / 2));
                return;
            }
            five--;
        }

        System.out.println(-1);
    }
}
