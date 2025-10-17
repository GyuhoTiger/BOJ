package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s2_19949 {
    static int[] answer = new int[10];
    static int[] choice = new int[10];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(input[i]);
        }

        dfs(0);

        System.out.println(count);
        br.close();
    }

    static void dfs(int depth) {
        if (depth == 10) {
            int score = 0;
            for (int i = 0; i < 10; i++) {
                if (choice[i] == answer[i]) score++;
            }
            if (score >= 5) count++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            // 같은 답 3번 연속 방지
            if (depth >= 2 && choice[depth - 1] == i && choice[depth - 2] == i) continue;

            choice[depth] = i;
            dfs(depth + 1);
        }
    }
}