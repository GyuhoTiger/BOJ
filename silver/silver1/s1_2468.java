package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_2468 {
    static int N, height;
	static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    // dfs
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        // 가장 높은 높이의 영역 -> 모든 높이에 대해 탐색해야 하므론
        int max = 0; 

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int answer = 0;

        for (height = 0; height <= max; height++) {
            visited = new boolean[N][N];
            int count = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && map[j][k] > height) { // 물에 잠기지 않은 잠기지 않은 지역 탐색
                        dfs(j, k);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        
        System.out.println(answer);
        br.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] > height) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
