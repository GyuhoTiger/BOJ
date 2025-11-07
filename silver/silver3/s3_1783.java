package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로길이 N
        int M = Integer.parseInt(st.nextToken()); // 가로길이 M

        int answer = 0;

        // 1일 경우 : 이동 불가
        if (N == 1) {
            answer = 1;
        }
        // 2일 경우 : 2, 3번 방향으로만 이동 가능, 4가지 이동 다 못하므로 최대 4칸 이동가능
        if (N == 2) {
            answer = Math.min((M + 1) / 2, 4);
        }
        // 3칸 이상일 경우
        if (N >= 3) {
            if (M >= 7) {
                answer = M - 2;
            } else {
                answer = Math.min(4, M);
            }
        }

        System.out.println(answer);
        br.close();
    }
}