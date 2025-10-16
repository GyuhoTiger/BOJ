package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1_1342 {
    static int[] alphabet = new int[26];
    static int length;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        length = S.length();
        for (int i = 0; i < length; i++) {
            alphabet[S.charAt(i) - 'a']++;
        }

        dfs(0, -1);

        System.out.println(answer);
        br.close();
    }

    static void dfs(int depth, int last) {
        if (depth == length) {
            answer++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == 0) continue;

            // 연속한 문자는 패스
            if (i == last) continue;

            alphabet[i]--;
            dfs(depth + 1, i);
            alphabet[i]++;
        }
    }
}