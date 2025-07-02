package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_25947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 선물의 개수 N
        long B = Long.parseLong(st.nextToken()); // 예산 B
        int A = Integer.parseInt(st.nextToken()); // 할인 받을 수 있는 선물 개수 A

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i] / 2; // 우선 반값으로 계산
            if (i >= A) {
                sum += arr[i - A] / 2; // 할인 범위 초과 시, 이전 가격 복구
            }

            if (sum > B) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(N);
        br.close();
    }
}