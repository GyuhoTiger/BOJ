package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_31575 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       
        boolean result = dfs(0, 0);
        System.out.println(result ? "Yes" : "No");
        br.close();
    }

    static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= M || y >= N) return false;
        if (map[x][y] == 0 || visit[x][y]) return false;
        if (x == M - 1 && y == N - 1) return true;

        visit[x][y] = true;

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (dfs(nx, ny)) return true;
        }

        return false;
    }
}