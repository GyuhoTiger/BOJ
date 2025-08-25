package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 T
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1).append('\n');
            } else {
                int dx = x1 - x2;
                int dy = y1 - y2;
                int d2 = dx * dx + dy * dy;
                int rp = r1 + r2;
                int rm = Math.abs(r1 - r2);
                int rp2 = rp * rp;
                int rm2 = rm * rm;

                if (d2 == rp2 || d2 == rm2) {
                    sb.append(1).append('\n');
                } else if (rm2 < d2 && d2 < rp2) {
                    sb.append(2).append('\n');
                } else {
                    sb.append(0).append('\n'); 
                }
            }
        }

        System.out.print(sb);
        br.close();
    }
}