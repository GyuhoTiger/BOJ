package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_16931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 맨 위와 맨 아래 면
        int answer = N * M * 2;


        // 동
        for (int i = 0; i < N; i++) {
            answer += arr[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                if (arr[i][j] > arr[i][j + 1]) {
                    answer += arr[i][j] - arr[i][j + 1];
                }
            }
        }


        // 서
        for (int i = 0; i < N; i++) {
            answer += arr[i][0];
            for (int j = 1; j < M; j++) {
                if (arr[i][j] > arr[i][j - 1]) {
                    answer += arr[i][j] - arr[i][j - 1];
                }
            }
        }

        // 남
        for (int j = 0; j < M; j++) {
            answer += arr[N - 1][j];
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i][j] > arr[i + 1][j]) {
                    answer += arr[i][j] - arr[i + 1][j];
                }
            }
        }

        // 북
        for (int j = 0; j < M; j++) {
            answer += arr[0][j];
            for (int i = 1; i < N; i++) {
                if (arr[i][j] > arr[i - 1][j]) {
                    answer += arr[i][j] - arr[i - 1][j];
                }
            }
        }
        
        System.out.println(answer);
        br.close();
    }
}