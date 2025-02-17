package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 큐
public class s5_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        // 제일 위의 수 버리고, 다음 수 맨 아래로 옮기고 반복
        while (queue.size() > 1) {
            sb.append(queue.poll()).append(' ');
            queue.offer(queue.poll());
        }
        sb.append(queue.poll());
        System.out.println(sb);
        br.close();
    }
}
