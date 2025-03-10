package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_26169 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int r, c, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        count = 0;
        findApple(r, c, 0);

        if(count >= 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        br.close();
    }

    public static void findApple(int r, int c, int depth) {
        if (depth > 3) return;
        if (board[r][c] == 1) count++;

        visited[r][c] = true;

        for(int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny] || board[nx][ny] == -1){
                continue;
            }

            findApple(nx, ny, depth + 1);

            if (count >= 2) return; 
        }

        visited[r][c] = false;
        if (board[r][c] == 1) count--;
    }
}
