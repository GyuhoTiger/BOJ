package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s2_25516 {
    static int n, k;
    static ArrayList<Integer>[] arr;
    static int[] apple;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i < n; ++i){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; ++i){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[p].add(c);
            arr[c].add(p);
        }

        apple = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            apple[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(0, 0));
        br.close();
    }

    static int dfs(int node, int depth) {
        if (depth > k) {
            return 0;    
        }

        visited[node] = true;
        int sum = apple[node];

        for (int next : arr[node]) {
            if (!visited[next]) {
                sum += dfs(next, depth + 1);
            }
        }

        return sum;
    }
}