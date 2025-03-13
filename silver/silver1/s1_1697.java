package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class s1_1697 {
    static int N, K;
    static int visited[] = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈이의 위치(술래)
        K = Integer.parseInt(st.nextToken()); // 동생의 위치
        
        if (N == K) { // 술래 위치 = 동생 위치인 경우 -> 반례 생각 꼬꼬꼮꼬꼮
            System.out.println(0);
            return;
        }

        bfs();
        br.close();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(N);
        visited[N] = 1; // 처음 시작 1로 구분

        while (!queue.isEmpty()) {
            int currentPosition = queue.poll();
            int nextPosition;

            for(int i = 0; i < 3; i++) {
                switch (i) {
                    case 0: nextPosition = currentPosition + 1; // 앞으로 1칸
                            break;
                    case 1: nextPosition = currentPosition - 1; // 뒤로 1칸
                            break;
                    default: nextPosition = currentPosition * 2; // 2배 순간이동
                            break;
                }

                if (nextPosition < 0 || nextPosition > 100000) {
                    continue;
                }

                if (visited[nextPosition] == 0) {
                    visited[nextPosition] = visited[currentPosition] + 1;
                    queue.add(nextPosition);

                    if (nextPosition == K) {
                        System.out.println(visited[nextPosition] - 1);
                        return;
                    }
                }
            }
        }
    }
}
