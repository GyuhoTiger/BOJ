package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_17070 {
    static int N;
    static int[][] home;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        home = new int[N][N]; // 새 집의 크기(N * N)

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // state -> 0 : 가로, 1 : 세로, 2 : 대각선
        dfs(0, 1, 0);

        System.out.println(count);
        br.close();
    }

    static void dfs(int x, int y, int state) {

        // 현재 칸이 유효한 칸인지 검사
        if (x >= N || y >= N || home[x][y] == 1) return;

        // 대각선으로 왔다면, 왼쪽과 위쪽 방향이 벽이 아닌지 확인
        if (state == 2) {
            if (x - 1 < 0 || y - 1 < 0) return;
            if (home[x][y - 1] == 1 || home[x - 1][y] == 1)
                return;
        }

        // 도착 여부 검사
        if (x == N - 1 && y == N - 1) {
            count++;
            return;
        }

        // 다음 각각의 방향으로 이동
        if (state == 0) {
            dfs(x, y + 1, 0);
            dfs(x + 1, y + 1, 2);
        } else if (state == 1) {
            dfs(x + 1, y, 1);
            dfs(x + 1, y + 1, 2);
        } else {
            dfs(x, y + 1, 0);
            dfs(x + 1, y, 1);
            dfs(x + 1, y + 1, 2);
        }
    }
}