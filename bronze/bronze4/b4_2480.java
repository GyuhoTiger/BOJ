package bronze.bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b4_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        int answer = 0;

        if (first == second && second == third) {
            answer = 10000 + first * 1000;
        } else if (first == second || first == third) {
            answer = 1000 + first * 100;
        } else if (second == third) {
            answer = 1000 + second * 100;
        } else {
            int max = Math.max(first, Math.max(second, third));
            answer = max * 100;
        }

        System.out.println(answer);
        br.close();
    }
}
