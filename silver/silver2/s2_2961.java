package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_2961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 요리의 개수
        int[] S = new int[N];  // 신맛
		int[] B = new int[N];  // 쓴맛

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
        }

        int total = (int)Math.pow(2, N);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < total; i++) {
            int sour = 1;
            int bitter = 0;

            int temp = i;
            for (int j = 0; j < N; j++) {
                if (temp % 2 == 1) {
                    sour *= S[j]; // 신맛은 곱하고
                    bitter += B[j]; // 쓴맛은 더한다
                }
                temp /= 2;
            }

            min = Math.min(min, Math.abs(sour - bitter));
        }

        System.out.println(min);
        br.close();
    }
}