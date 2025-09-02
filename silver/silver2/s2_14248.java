package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_14248 {
    static int N;
    static int[] jump;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        jump = new int[N + 1]; // 1-indexed
        for (int i = 1; i <= N; i++) {
            jump[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine().trim());
        visited = new boolean[N + 1];

        System.out.println(bfs(start));
        br.close();
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (true) {
            if (queue.isEmpty()) {
                break;
            }

            int cur = queue.poll();
            count++;

            int left = cur - jump[cur];
            int right = cur + jump[cur];

            if (left >= 1 && !visited[left]) {
                visited[left] = true;
                queue.offer(left);
            }
            if (right <= N && !visited[right]) {
                visited[right] = true;
                queue.offer(right);
            }
        }
        return count;
    }
}