package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s4_13413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수 T

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 오셀로 판 크기
            String start = br.readLine(); // 현재 상태
            String goal = br.readLine();  // 목표 상태

            int bw = 0; // B -> W
            int wb = 0; // W -> B

            for (int i = 0; i < N; i++) {
                char s = start.charAt(i);
                char g = goal.charAt(i);

                if (s != g) {
                    if (s == 'B') bw++;
                    else wb++;
                }
            }

            System.out.println(Math.max(bw, wb));
        }
        
        br.close();
    }
}