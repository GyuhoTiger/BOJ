package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이진 탐색
public class g5_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입국심사대 개수 N
        int M = Integer.parseInt(st.nextToken()); // 친구들 수 M


        long[] time = new long[N];
        long max = 0;
        for (int i = 0; i < N; i++) {
            time[i] = Long.parseLong(br.readLine());
            max = Math.max(max, time[i]);
        }

        long left = 1;
        long right = 1_000_000_000_000_000_000L;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long people = 0;
        
            for (int i = 0; i < N; i++) {
                people += mid / time[i];
                if (people >= M) break;
            }
        
            if (people >= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
        br.close();
    }
}