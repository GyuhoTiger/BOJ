package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        int N = 1;
        long sum = 0;
        long count = 0;
        while (true) {
            if (sum + N > S) {
                break;
            }
            sum += N;
            count++;
            N++;
        }

        System.out.println(count);
        br.close();
    }
}