package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_1913 {
    // 위 -> 오른쪽 -> 아래 -> 왼쪽
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int target  = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int targetX = 0, targetY = 0; // target의 좌표

        snail(N, target, arr);
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
                // 찾는 숫자가 1일 경우
                if(arr[i][j] == target) {
                    targetX = i + 1;
                    targetY = j + 1;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(targetX + " " + targetY);
        br.close();
    }

    public static void snail(int N, int target, int[][] arr) {
        int x = N / 2, y = N / 2;
        int startNumber = 1;
        int d = 0;
        int step = 1; // 현재 이동해야 할 칸 수
        int count = 0;

        arr[x][y] = startNumber;

        while (startNumber < N * N) {
            for (int i = 0; i < step; i++) {
                x += dx[d];
                y += dy[d];
                startNumber++;
                arr[x][y] = startNumber;
                if (startNumber == N * N) break;
            }

            d = (d + 1) % 4; // 방향 전환
            count++;

            // 같은 step을 두 번 반복하면 step 증가
            if (count == 2) {
                count = 0;
                step++;
            }
        }
    }
}
