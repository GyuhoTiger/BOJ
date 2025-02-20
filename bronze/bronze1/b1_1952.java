package bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1_1952 {
    // 오른쪽 -> 아래 -> 왼쪽 -> 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        System.out.println(snail(M, N));
        br.close();
    }

    public static int snail(int M, int N) {
        boolean[][] check = new boolean[M][N];
        int x = 0, y = 0, d = 0, count = 0; // d : 방향
        int visit = 1;

        while(visit < M * N) {
            check[x][y] = true;
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 이탈 또는 이미 방문한 경우
            if(nx < 0 || nx >= M || ny < 0 || ny >= N || check[nx][ny]) {
                d = (d + 1) % 4; // 방향 변경
                count++;
                nx = x + dx[d];
                ny = y + dy[d];
            }

            x = nx;
            y = ny;
            check[x][y] = true;
            visit++;
        }
        return count;
    }
}
