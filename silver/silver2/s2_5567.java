package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs
public class s2_5567 {
    static int n, m;
    static ArrayList<Integer>[] friend;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 동기의 수
        int m = Integer.parseInt(br.readLine()); // 리스트의 길이

        friend = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            friend[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }

        System.out.println(bfs()); 
        br.close();
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;

        int count = 0;
        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int currentFriend = queue.poll();

                for(int nextFriend : friend[currentFriend]) {
                    if(!visited[nextFriend]) {
                        visited[nextFriend] = true;
                        queue.add(nextFriend);
                        count++;
                    }
                }
            }

            distance++;

            if(distance == 2) {
                break;
            }
        }

        return count;
    }
}
