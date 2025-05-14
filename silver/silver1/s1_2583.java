package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class s1_2583 {
    static int M, N, K;
    static boolean[][] paper;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken()); // 직사각형 수

        paper = new boolean[M][N];

        // 종이의 직사각형 방문
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    paper[j][k] = true;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[i][j] == false) {
                    size = 0;
                    dfs(i, j);
                    list.add(size);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());

        for (int size : list) {
            System.out.print(size + " ");
        }
        br.close();
    }

    static void dfs(int y, int x) {
        paper[y][x] = true;
        size++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && ny < M && nx < N) {
                if (paper[ny][nx] == false) {
                    dfs(ny, nx);
                }
            }
        }
    }
}