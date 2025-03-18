package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간합
public class s3_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 수의 개수 N
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 M

        int[] InputArr = new int[N + 1];
        int[] sumArr = new int[N + 1];
        int sum = 0;
        // 누적합
        st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
            InputArr[i] = Integer.parseInt(st.nextToken());
            sum += InputArr[i];
            sumArr[i] = sum;
		}

        for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(sumArr[end] - sumArr[start - 1]).append("\n");
		}

        System.out.println(sb);
        br.close();
    }
}