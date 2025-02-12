package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우선순위 큐
public class s3_2075 {
    public static void main(String[] args) throws  IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int number = Integer.parseInt(st.nextToken());
				if(queue.size() == N) {
					if(queue.peek() < number) {
						queue.poll();
						queue.add(number);
					}
				} else {
					queue.add(number);
				}
			}
		}
		System.out.println(queue.poll());
        br.close();
    }
}
