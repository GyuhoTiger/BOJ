package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_16943 {
    static char[] A;
    static int B;
    static boolean[] visited;
    static int max = -1;
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken().toCharArray();
        B = Integer.parseInt(st.nextToken());

        visited = new boolean[A.length];

        dfs("", 0);

        System.out.println(max);
        br.close();
    }

    static void dfs(String current, int depth) {
        if (depth == A.length) {
            if (current.charAt(0) == '0') return;
            int num = Integer.parseInt(current);
            if (num < B) {
                max = Math.max(max, num);
            }
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + A[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}