package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 투포인터
public class g5_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터를 쓰기 위한 배열 정렬
        Arrays.sort(arr);

        int left = 0; // 왼쪽(처음)
        int right = N - 1; // 오른쪽(끝)
        int min = Integer.MAX_VALUE;
        int answer1 = 0, answer2 = 0; // 두 용액

        while (left < right) {
            int sum = arr[left] + arr[right];
            // 현재 두 용액의 합이 최소값보다 작으면 갱신
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer1 = arr[left];
                answer2 = arr[right];
            }

            // 합이 0보다 작으면 왼쪽 포인터 -> 오른쪽으로 이동, 합이 0보다 크면 오른쪽 포인터 -> 왼쪽으로 이동
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer1 + " " + answer2);
        br.close();
    }
}