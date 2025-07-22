package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        //  2^(n - (n - m) - m) * 5^(n - (n - m) - m)
        long two = combiTwo(n) - combiTwo(n - m) - combiTwo(m);
        long five = combiFive(n) - combiFive(n - m) - combiFive(m);

        System.out.println(Math.min(two, five));
        br.close();
    }

    // 2 소인수 개수
    public static long combiTwo(long number) {

        long count = 0;

        while (number >= 2) {
            count += number / 2;
            number /= 2;
        }
        return count;
    }

    // 5 소인수 개수
    public static long combiFive(long number) {

        long count = 0;

        while (number >= 5) {
            count += number / 5;
            number /= 5;
        }
        return count;
    }
}