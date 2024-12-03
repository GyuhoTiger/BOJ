package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 투 포인터 알고리즘
public class s3_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // 배열 정렬

        int start = 0;
        int end = N - 1;
        int sum = 0;
        int count = 0;

        // 정렬된 배열에서 왼쪽 끝과 오른쪽 끝에서 두 개의 포인터를 번갈아가면서 접근
        while(start < end) { // 교차하는 순간 종료
            sum = arr[start] + arr[end];
            if(sum < x) {
                start++; // 두 수의 합이 x보다 더 작을 경우
            } else if (sum == x) {
                end--;
                count++; // 만족하면 count 증가
            } else if (sum > x) {
                end--; // 두 수의 합이 x보다 더 클 경우
            }
        }
        System.out.println(count);
        br.close();
    }
}
