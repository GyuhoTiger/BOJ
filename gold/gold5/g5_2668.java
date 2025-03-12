package gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class g5_2668 {
    static int N, target;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        result = new ArrayList<Integer>();

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            target = i;
            dfs(i);
            visited[i] = false;
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void dfs(int start) {
        if(arr[start] == target) {
            result.add(target);
        }
        if(visited[arr[start]] == false) {
            visited[arr[start]] = true;
            dfs(arr[start]);
            visited[arr[start]] = false;
        }
    }
}
