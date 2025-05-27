package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이분 탐색
public class s2_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int M = Integer.parseInt(br.readLine());

        int low = 0;
        int high = max;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long total = 0;

            for (int i = 0; i < N; i++) {
                total += Math.min(arr[i], mid);
            }

            if (total <= M) {
                result = mid;   // 상한액 확인 : 더 높일 수 있는지
                low = mid + 1;
            } else {
                high = mid - 1; // 상한액이 너무 높을 경우 : 낮추기
            }
        }

        System.out.println(result);
        br.close();
    }
}