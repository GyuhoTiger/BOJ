package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 길이 N
        int K = Integer.parseInt(st.nextToken()); // 내구도가 0인 칸의 개수 K

        int[] belt = new int[2 * N]; // 컨베이어 벨트 내구도
        boolean[] robot = new boolean[N];   // 로봇 위치
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        while (true) {
            count++;

            // 1. 컨베이어 벨트 회전
            int lastNumber = belt[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = lastNumber;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }

            robot[0] = false; // 올리는 위치 비우기
            robot[N - 1] = false; // 내리는 위치 비우기

            // 2. 로봇 이동
            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    belt[i]--;
                }
            }

            robot[N - 1] = false; // 내리는 위치 비우기

            // 3. 로봇 올리기
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            // 4. 내구도 0인 칸 확인
            int zero = 0;
            for (int d : belt) {
                if (d == 0) {
                    zero++;
                }
            }

            if (zero >= K) break;
        }

        System.out.println(count);
        br.close();
    }
}