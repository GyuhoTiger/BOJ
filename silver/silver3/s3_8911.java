package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_8911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        String[] move = new String[T];

        for (int i = 0; i < T; i++) {
            move[i] = br.readLine();
        }

        int[] dx = {0, 1, 0, -1}; // 북, 동, 남, 서
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < T; i++) {
            int x = 0, y = 0;
            int minX = 0, maxX = 0, minY = 0, maxY = 0;
            int dir = 0; // 0: 북, 1: 동, 2: 남, 3: 서

            for (int j = 0; j < move[i].length(); j++) {
                char c = move[i].charAt(j);

                if (c == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                } else if (c == 'B') {
                    x -= dx[dir];
                    y -= dy[dir];
                } else if (c == 'L') {
                    dir = (dir + 3) % 4;
                } else if (c == 'R') {
                    dir = (dir + 1) % 4;
                }

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }

            int width = maxX - minX;
            int height = maxY - minY;
            System.out.println(width * height);
        }

        br.close();
    }
}