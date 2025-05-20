package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int len = 1;
                while (true) {
                    if(i + len >= N || j + len >= M) {
                        break;
                    }

                    if (map[i][j] == map[i + len][j] && map[i][j] == map[i][j + len] && map[i][j] == map[i + len][j + len]) {
                        int size = (len + 1) * (len + 1);
                        if (size > answer) {
                            answer = size;
                        }
                    }
                    len++;
                }
            }
        }
        
        System.out.println(answer);
        br.close();
    }
}