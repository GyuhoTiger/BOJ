package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 큐
public class s1_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수 n
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이 w
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대하중 L

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        System.out.println(truck(queue, w, L));
        br.close();
    }

    public static int truck(Queue<Integer> queue, int length, int weight) {
        int time = 0;
        int currentWeight = 0;
        Queue<Integer> bridge = new LinkedList<Integer>();

        for(int i = 0; i < length; i++) {
            bridge.offer(0);
        }

        while(!bridge.isEmpty()) {
            time++;
            currentWeight -= bridge.poll(); // 다리에서 트럭이 완전히 지나가면 무게 감소

            // 트럭이 다리에 올라갈 수 있는지 확인
            if (!queue.isEmpty()) {
                if (queue.peek() + currentWeight <= weight) {
                    int nextTruck = queue.poll();
                    bridge.add(nextTruck);
                    currentWeight += nextTruck;
                } else {
                    bridge.add(0); // 트럭이 못올라가면 0
                }
            }
        }
        return time;
    }
}
