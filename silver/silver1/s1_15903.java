package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 카드의 개수 N
        int M = Integer.parseInt(st.nextToken()); // 카드 합체 횟수 M

        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } 

        for (int i = 0; i < M; i++) {
			Arrays.sort(arr);
			long number = arr[0] + arr[1];
			arr[0] = number;
			arr[1] = number;
		}

        long sum = 0;
		
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}

		System.out.println(sum);
        br.close();
    }
}