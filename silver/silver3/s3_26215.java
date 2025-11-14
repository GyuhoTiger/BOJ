package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class s3_26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while (!q.isEmpty()) {
			int a = q.poll();

			if (q.isEmpty()) {
				result += a;
				break;
			}
			int b = q.poll();
			result += b;
			q.add(a - b);
		}

		if (result > 1440) {
			System.out.println(-1);
        } else {
			System.out.println(result);
        }

        br.close();
    }
}