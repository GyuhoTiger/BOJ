package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class s1_1926 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] pic;
    static boolean[][] filled;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pic = new int[N][M];
        filled = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                pic[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0; // 그림의 개수
        int max = 0; // 가장 넓은 그림의 넓이

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(pic[i][j] == 1 && filled[i][j] == false) {
                    count++;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
        br.close();
    }

    // bfs 정의
    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        filled[x][y] = true;

        int size = 0; // 현재 그림 크기

        while (!q.isEmpty()) {
            int[] node = q.poll();
            size++;

            // 4방향 탐색
            for(int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(filled[nx][ny] || pic[nx][ny] == 0) continue;

                filled[nx][ny] = true;
                q.add(new int[] {nx, ny});
            }
        }
        return size;
    }
}
