package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class s3_25418 {
    static int A, K;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken()); // 양의 정수 A를
        K = Integer.parseInt(st.nextToken()); // 양의 정수 K로 만들기
        visited = new boolean[1000001];

        bfs();
        br.close();
    }
    
    static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(A);
        visited[A] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentNumber = queue.poll();

                if (currentNumber == K) { 
                    System.out.println(count);
                    return;
                }

                for (int j = 0; j < 2; j++) {
                    int nextNumber = 0;

                    switch (j) {
                        case 0:
                        nextNumber = currentNumber + 1;
                            break;
                        case 1:
                        nextNumber = currentNumber * 2;
                            break;
                    }

                    if (nextNumber <= 1000000 && !visited[nextNumber]) {
                        visited[nextNumber] = true;
                        queue.add(nextNumber);
                    }
                }
            }
            count++;
        }
    }
}