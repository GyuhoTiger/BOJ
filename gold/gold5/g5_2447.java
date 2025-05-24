package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class g5_2447 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        star(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    // 별 채우기
    static void star(int x, int y, int size) {
        if (size == 1) {
            map[x][y] = '*';
            return;
        }

        // 정사각형을 3등분
        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 9개 중 정 가운데일 때 : 공백 채우기
                if (i == 1 && j == 1) {
                    blank(x + newSize, y + newSize, newSize);
                } else {
                    star(x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }

    // 공백 채우기
    static void blank(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = ' ';
            }
        }
    }
}