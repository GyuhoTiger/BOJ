package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4_1388 {
    public static int N, M;
    public static char[][] floor;
    public static boolean[][] visited;
    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        floor = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            floor[i] = st.nextToken().toCharArray();
        }

        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, floor[i][j]);
                    count++;
                }
            }
        }

        System.out.println(count);
        br.close();
    }

    public static void dfs(int x, int y, char pattern){
        visited[x][y] = true;

        for(int d = 0; d < 2; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

           // '-'일 경우 : 오른쪽 탐색
            if(pattern == '-' && d == 0 && ny < M && floor[x][ny] == pattern && !visited[x][ny]) {
                dfs(x, ny, pattern);
            }

            // '|'일 경우 : 아래 탐색
            if(pattern == '|' && d == 1 && nx < N && floor[nx][y] == pattern && !visited[nx][y]) {
                dfs(nx, y, pattern);
            }
        }
    }
}
