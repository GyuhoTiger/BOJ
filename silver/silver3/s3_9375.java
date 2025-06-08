package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class s3_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수 T

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 가진 의상의 수 N
            Map<String, Integer> map = new HashMap<>(); // 중복 피해야하므로 HashMap

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String dress = st.nextToken(); // 의상 종류만 사용

                map.put(dress, map.getOrDefault(dress, 0) + 1);
            }

            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1); // 안입는 경우도 포함해야해서 + 1, 곱해서 전체 조합가지수 계산
            }

            System.out.println(result - 1);
        }
        br.close();
    }
}