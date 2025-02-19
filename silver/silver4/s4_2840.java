package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s4_2840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 바퀴 칸 수
        int K = Integer.parseInt(st.nextToken()); // 회전 횟수

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        boolean[] check = new boolean[26];

        int temp = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 회전 칸 수
            char C = st.nextToken().charAt(0); // 입력 문자

            temp = (temp + S) % N; // 화살표 위치


            // 중복된 문자가 다른 위치에 있는 경우
            if (check[C - 'A'] == true && wheel[temp] != C) {
                System.out.println("!");
                return;
            }

            // 이미 다른 문자가 있는 경우
            if (wheel[temp] != '?' && wheel[temp] != C) {
                System.out.println("!");
                return;
            }

            // 바퀴에 문자 저장
            wheel[temp] = C;
            check[C - 'A'] = true;
        }

        // 바퀴 상태를 반시계 방향으로 출력
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            answer.append(wheel[(temp - i + N) % N]);
        }

        System.out.println(answer.toString());
        br.close();
    }
}
