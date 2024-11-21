package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_2178 {

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0); // 처음 탐색 지역 (0, 0)
        
        System.out.println(map[N - 1][M - 1]);
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {x, y});
        visit[x][y] = true; // 첫 방문 지역 -> 탐색한 상태에서 시작

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            for (int i = 0; i < 4; i++) { // 상하좌우 탐색

                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny] && map[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    map[nx][ny] = map[tmp[0]][tmp[1]] + 1;
                    queue.add(new int[] {nx, ny}); 
                }
            }
        }
    }
}
