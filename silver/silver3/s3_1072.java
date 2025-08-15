package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());  // 게임 횟수 X
		long Y = Integer.parseInt(st.nextToken());  // 이긴 게임 횟수 Y

        long Z = Y * 100 / X; // 승률 Z

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 0;
        long right = 1000000000;

        while (left < right) {
            long mid = (left + right) / 2;
            long game = (Y + mid) * 100 / (X + mid);

            if (game > Z) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
        br.close();
    }
}