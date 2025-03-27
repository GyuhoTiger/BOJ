package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백트래킹
public class s2_15663 {
    static int N, M;
    static int[] arr, answer;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 숫자의 개수 N
        M = Integer.parseInt(st.nextToken()); // 수열의 길이 M

        arr = new int[N];
        answer = new int[M];
        visit = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb);
        br.close();
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
    
        for (int i = 0; i < N; i++) {
			if(!visit[i]) {
                // 중복방지 조건
                if (i > 0 && arr[i] == arr[i - 1] && !visit[i - 1]) {
                    continue;
                }

				visit[i] = true;
				answer[depth] = arr[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
    }
}
