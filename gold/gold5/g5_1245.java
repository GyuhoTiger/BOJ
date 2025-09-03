package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_1245 {
    static int N, M;
    static int[][] map;
	static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean peak;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {			
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    peak = true;
                    dfs(i, j);
                    if (peak) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
        br.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            // 꼭대기가 아니면 peak = false
            if (map[nx][ny] > map[x][y]) {
                peak = false;
            }

            // 같은 높이의 칸은 같은 덩어리로 탐색
            if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
                dfs(nx, ny); 
            }
        }
    }
}