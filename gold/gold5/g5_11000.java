package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class g5_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 강의 개수 N

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        // 시작시간 기준으로 정렬
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        // 우선순위 큐 생성 & 첫 번째 시작시간의 종료시간을 넣어줌
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i][0]) {
                pq.poll();
            }
            pq.offer(arr[i][1]);
        }

		System.out.println(pq.size());
		br.close();
    }
}