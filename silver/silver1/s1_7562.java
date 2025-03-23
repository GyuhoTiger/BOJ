package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_7562 {
    static int L, startX, startY, endX, endY;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for (int i = 0; i < T; i++) {
            L = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            bfs();
        }
        System.out.print(sb);
        br.close();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>(); // (x, y) 형식으로 위치를 저장하기 위한 큐 
        boolean[][] visited = new boolean[L][L];

        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int count = 0; // 이동 횟수

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int[] arr = queue.poll();
                int x = arr[0], y = arr[1];
    
                if (x == endX && y == endY) {
                    System.out.println(count);
                    return;
                }
    
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j], ny = y + dy[j];
    
                    if (nx >= 0 && ny >= 0 && nx < L && ny < L && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            count++;
        }
    }
}
