package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 인형의 개수 N
        int K = Integer.parseInt(st.nextToken()); // K개 이상의 라이언 인형을 포함하는 집합

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int count = 0;
        int len = Integer.MAX_VALUE;

        while (right < N) {
            // 오른쪽 포인터 옮기기
            if (arr[right] == 1) {
                count++;
            }

            // K 이상이면 최소 집합 크기 갱신 & 왼쪽 줄이기
            while (count >= K) {
                len = Math.min(len, right - left + 1);
                if (arr[left] == 1) {
                    count--;
                }
                left++;
            }
            right++;
        }

        if (len == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(len);
        }

        br.close();
    }
}