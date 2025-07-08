package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class s3_31964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 집의 수 N

        int[][] arr = new int[N][2]; // [0] = 집의 위치, [1] = 물건 내놓는 시각

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 집의 위치 기준으로 정렬
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        long time = arr[N - 1][0];

        for (int i = N - 1; i >= 0; i--) {
            if (i < N - 1) {
                time += arr[i + 1][0] - arr[i][0];
            }
            if (time < arr[i][1]) {
                time = arr[i][1];
            }
        }

        // 출발지로 복귀
        time += arr[0][0];

        System.out.println(time);
        br.close();
    }
}