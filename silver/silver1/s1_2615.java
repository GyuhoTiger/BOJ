package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_2615 {
    static int[][] board = new int[19][19];
    // 우, 하, 오른쪽 아래, 오른쪽 위
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (board[x][y] != 0) {
                    int color = board[x][y];

                    for (int d = 0; d < 4; d++) {
                        int count = 1;
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        while (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && board[nx][ny] == color) {
                            count++;
                            if (count > 5) {
                                break;
                            }

                            nx += dx[d];
                            ny += dy[d];
                        }

                        int px = x - dx[d];
                        int py = y - dy[d];

                        if (count == 5 && (!(px >= 0 && px < 19 && py >= 0 && py < 19) || board[px][py] != color)) {
                            System.out.println(color);
                            System.out.println((x + 1) + " " + (y + 1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
        br.close();
    }
}