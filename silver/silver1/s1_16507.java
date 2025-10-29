package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_16507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 행의 수 R
        int C = Integer.parseInt(st.nextToken()); // 열의 수 C
        int Q = Integer.parseInt(st.nextToken()); // 밝기 평균 개수 Q

        int[][] arr = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            for (int j = r1; j <= r2; j++) {
                sum += arr[j][c2] - arr[j][c1 - 1];
            }

            int total = (r2 - r1 + 1) * (c2 - c1 + 1);
            int result = sum / total;

            sb.append(result).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}