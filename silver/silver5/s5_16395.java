package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5_16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] pascal = new int[N + 1][N + 1];

        pascal[1][1] = 1;

        // 모서리는 1로 채우기
        for(int i = 1; i <= N; i++) {
            pascal[i][1] = 1;
            pascal[i][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 2; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        // 2중 반복문 하나로 모서리에 1 채우는 방법...
        // for (int i = 1; i <= N; i++) {
        //     for (int j = 1; j <= i; j++) { 
        //         if (j == 1 || j == i) { 
        //             pascal[i][j] = 1;
        //         } else { 
        //             pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
        //         }
        //     }
        // }

        System.out.println(pascal[N][K]);
        br.close();
    }
}