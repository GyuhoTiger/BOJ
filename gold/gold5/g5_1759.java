package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_1759 {
    static int L, C;
    static char[] arr, password;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 암호 알파벳 소문자 L자리수
        C = Integer.parseInt(st.nextToken()); // 알파벳 구성 C개

        arr = new char[C];
        password = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(arr);

        dfs(0, 0);

        System.out.print(sb);
        br.close();
    }

    static void dfs(int depth, int start) {
        if (depth == L) {
            // vowel = 모음, consonant = 자음
            int vowel = 0, consonant = 0;
            for (int i = 0; i < L; i++) {
                char c = password[i];
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowel++;
                } else {
                    consonant++;
                }
            }
            // 최소 한 개의 모음, 최소 두 개의 자음으로 구성
            if (vowel >= 1 && consonant >= 2) {
                sb.append(password).append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}