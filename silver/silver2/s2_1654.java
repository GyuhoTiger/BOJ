package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분 탐색 (너무 어려웠음,,,,)
public class s2_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] LAN = new long[K];

        for(int i = 0; i < K; i++) {
            LAN[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(LAN);

        long max = LAN[K - 1];
        long min = 1;
        long result = 0;

        while(min <= max) { 
            long mid = (max + min) / 2;
            int count = 0;

            for(int i = 0; i < K; i++) {
                count += LAN[i] / mid; // mid 길이로 자를 수 있는 랜선 개수
            }
            if(count < N) { // 랜선 개수 부족
                max = mid - 1; // 상한 범위 줄이기
            } else {
                result = mid;
                min = mid + 1; // 하한 범위 늘리기
            }
        }
        System.out.println(result);
        br.close();
    }
}
