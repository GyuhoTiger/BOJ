package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[101][101];

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 좌표 범위에 1 넣기
            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        // 넓이 구하기
        int sum = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
        br.close();
    }
}