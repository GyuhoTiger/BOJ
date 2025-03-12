package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백트래킹
public class s3_15656 {
    static int N, M;
    static int[] arr, answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);

        System.out.println(sb);
        br.close();
    }

    static void dfs(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
				sb.append(answer[i] + " ");
			}
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            answer[depth] = arr[i];
            dfs(depth + 1);
        }
    }
}
