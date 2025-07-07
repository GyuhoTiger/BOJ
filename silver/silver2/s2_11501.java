package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

    		long answer = 0;
    		long profit = 0; // 가장 높은 주가

            // 역방향 순회하면서 현재 주가보다 더 낮은 주가 만나면 차익만큼 누적
    		for (int j = (N - 1); j >= 0; j--) {
    			if (profit < arr[j]) {
    				profit = arr[j];
    			} else {
    			    answer += profit - arr[j];
    			}
    		}
            System.out.println(answer);
        }
        br.close();
    }
}