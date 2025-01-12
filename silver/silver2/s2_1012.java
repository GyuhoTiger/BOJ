package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs
public class s2_1012 {

    static int[][] map; // 배추밭
    static boolean[][] visited;
    static int M, N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];

            int K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int worm = 0;

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        worm++;
                    }
                }
            }
            System.out.println(worm);
        }
        br.close();
    }

    private static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
                
            // 배추밭 벗어나는지 체크, 방문 안했으면 재귀 호출
            if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if(map[nx][ny] == 1 & !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}

