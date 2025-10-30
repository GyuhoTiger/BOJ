package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_16713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수열의 길이 N
        int Q = Integer.parseInt(st.nextToken());   // 쿼리의 개수 Q

        st = new StringTokenizer(br.readLine());
        int[] number = new int[N + 1];
        int[] xor = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            xor[i] = xor[i - 1] ^ number[i];
        }

        int answer = 0;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            answer ^= xor[s - 1] ^ xor[e];
        }

        System.out.println(answer);
        br.close();
    }
}