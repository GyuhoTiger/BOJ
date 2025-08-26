package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 T

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine()); // 원의 개수 n
            int count = 0;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r1  = Integer.parseInt(st.nextToken());

                // 제곱 거리로 비교
                long dx1 = x1 - cx;
                long dy1 = y1 - cy;
                long dist1 = dx1 * dx1 + dy1 * dy1;

                long dx2 = x2 - cx;
                long dy2 = y2 - cy;
                long dist2 = dx2 * dx2 + dy2 * dy2;

                long r2 = ((long)r1 * r1);

                boolean in1 = dist1 < r2; // 출발점이 원 내부인지
                boolean in2 = dist2 < r2; // 도착점이 원 내부인지

                // 한 점이 내부인 경우
                if (in1 != in2) {
                    count++;
                }
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}