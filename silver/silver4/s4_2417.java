package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이분 탐색
public class s4_2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        
        long left = 0; // 최솟값 0부터 시작
        long right = N; // 최댓값 N까지
        long answer = 0;
        long mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            
            if (Math.pow(mid, 2) >= N) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
        br.close();
    }
}