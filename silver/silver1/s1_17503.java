package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class s1_17503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 맥주 수 N
        int M = Integer.parseInt(st.nextToken()); // 선호도 합 M
        int K = Integer.parseInt(st.nextToken()); // 맥주 종류 수 K

        int[][] beer = new int[K][2]; 
        // beers[i][0] = 선호도, beers[i][1] = 도수

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            beer[i][0] = Integer.parseInt(st.nextToken());
            beer[i][1] = Integer.parseInt(st.nextToken());
        }

        // 도수 기준 정렬
        Arrays.sort(beer, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 선호도 최소 힙
        long sum = 0;
        int answer = -1;

        for (int i = 0; i < K; i++) {
            minHeap.add(beer[i][0]);
            sum += beer[i][0];

            if (minHeap.size() > N) {
                sum -= minHeap.poll(); // 가장 작은 선호도 제거
            }

            if (minHeap.size() == N && sum >= M) {
                answer = beer[i][1]; // 현재 도수가 최소의 최대 도수
                break;
            }
        }

        System.out.println(answer);
        br.close();

    }
}