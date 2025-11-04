package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int arr[] = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int result[] = new int[N];
			int start = 0;
            int end = N - 1;
            int index = 0;

			for (int j = 0; j < N; j++) {
				if (index % 2 == 0) {
					result[start++] = arr[index++];
				} else {
					result[end--] = arr[index++];
				}
			}

			int answer = Math.abs(result[N - 1] - result[0]);
			for (int j = 0; j < N - 1; j++) {
				if (answer < Math.abs(result[j] - result[j + 1]))
					answer = Math.abs(result[j] - result[j + 1]);
			}

            System.out.println(answer);
        }

        br.close();
    }
}