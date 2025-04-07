package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class s4_5568 {
    static int N, K;
    static String[] cards;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 카드 수 N
        K = Integer.parseInt(br.readLine()); // 그 중에서 선택하는 K

        cards = new String[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            cards[i] = br.readLine();
        }
        
        dfs("", 0);

        System.out.println(set.size());
        br.close();
    }

    static void dfs(String index, int depth) {
        if (depth == K) {
            set.add(index);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(index + cards[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}