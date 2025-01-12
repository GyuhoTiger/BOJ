package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복조합(백트래킹)
public class s3_15652 {
    static int N, M;
    static int[] arr;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        
        dfs(0, 0);
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int depth, int index) {
        if (depth == M) { // 종료조건
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 탐색
        for (int i = index; i < N; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1, i);
        }
    }
}
