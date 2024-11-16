package silver.silver4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s4_11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        // 큐에 1 ~ N 값 넣기
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        sb.append('<');

        // 요세푸스 순열
        while (queue.size() > 1) {
            for(int i = 0; i < K - 1; i++) {
                int number = queue.poll();
                queue.offer(number);
            }
            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append('>');
        System.out.println(sb);
        sc.close();
    }
}