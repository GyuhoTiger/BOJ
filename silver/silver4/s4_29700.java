package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4_29700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 영화관 세로줄의 개수 N
        int M = Integer.parseInt(st.nextToken()); // 영화관 가로줄의 개수 M
        int K = Integer.parseInt(st.nextToken()); // 관람할 동아리원 수 K

        int result = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int count = 0;
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '0') {
                    count++;
                } else {
                    if (count >= K) {
                        result += (count - K + 1);
                    }
                    count = 0;
                }
            }
            if (count >= K) {
                result += (count - K + 1);
            }
        }

        System.out.println(result);
        br.close();
    }
}