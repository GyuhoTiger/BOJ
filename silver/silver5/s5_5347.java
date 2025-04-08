package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5_5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            sb.append(a * b / LCM(a, b)).append("\n");
	    }

	    System.out.print(sb);
        br.close();
    }

    public static long LCM(long a, long b) {
	    while (b > 0) {
	        long temp = a;
	        a = b;
	        b = temp % b;
	    }
	    return a;
	}
}