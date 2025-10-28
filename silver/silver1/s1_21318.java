package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
        int[] music = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            music[i] = Integer.parseInt(st.nextToken());
        }

        int[] mistakes = new int[N + 1];
        mistakes[0] = 0;
        for (int i = 1; i < N; i++) {
            if (music[i] > music[i + 1]) {
                mistakes[i] = mistakes[i - 1] + 1;
            } else {
                mistakes[i] = mistakes[i - 1];
            }
        }
        // 마지막 채우기
        mistakes[N] = mistakes[N - 1];

        int Q = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = mistakes[y - 1] - mistakes[x - 1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}