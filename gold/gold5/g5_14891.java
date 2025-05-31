package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_14891 {
    static int[][] gear = new int[4][8]; // 톱니바퀴 4개, 각각 8개의 톱니
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine()); // 회전 횟수 K

        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int gearNum = Integer.parseInt(st.nextToken()) - 1; // 기어 번호
            int gearDir = Integer.parseInt(st.nextToken()); // 기어 방향

            int[] dir = new int[4]; // 각각의 톱니바퀴 회전 방향

            dir[gearNum] = gearDir;

            // 왼쪽
            for (int j = gearNum - 1; j >= 0; j--) {
                if (gear[j][2] != gear[j + 1][6]) {
                    dir[j] = -1 * dir[j + 1];
                } else {
                    break;
                }
            }

            // 오른쪽
            for (int j = gearNum + 1; j < 4; j++) {
                if (gear[j - 1][2] != gear[j][6]) {
                    dir[j] = -dir[j - 1];
                } else {
                    break;
                }
            }

            // 회전
            for (int j = 0; j < 4; j++) {
                if (dir[j] == 0) {
                    continue;
                }
                rotate(j, dir[j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer += (int)Math.pow(2, i) * gear[i][0];
        }

        System.out.println(answer);
        br.close();
    }

    static void rotate(int index, int direction) {
        if (direction == 0) {
            return;
        }

        // 시계 방향
        if (direction == 1) {
            int temp = gear[index][7];
            for (int i = 7; i > 0; i--) {
                gear[index][i] = gear[index][i - 1];
            }

            gear[index][0] = temp;

        // 반시계 방향
        } else {
            int temp = gear[index][0];
            for (int i = 0; i < 7; i++) {
                gear[index][i] = gear[index][i + 1];
            }
            gear[index][7] = temp;   
        }
    }
}