package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS -> 최단거리탐색
public class s1_16948 {
    static int N;
    static int dx[] = {-2, -2, 0, 0, 2, 2};
    static int dy[] = {-1, 1, -2, 2, -1, 1};
    static int[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 체스판의 크기 N

        visit = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int answer = bfs(r1, c1, r2, c2);

        System.out.println(answer);
        br.close();
    }

    public static int bfs(int r1, int c1, int r2, int c2) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r1, c1});
        visit[r1][c1] = 1;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            if (x == r2 && y == c2) {
                return visit[x][y] - 1;
            }

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && visit[nx][ny] == 0) {
                    visit[nx][ny] = visit[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}