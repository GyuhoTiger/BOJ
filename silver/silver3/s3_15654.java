package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백트래킹
public class s3_15654 {
    static int N, M;
    static int[] arr; // N개의 숫자를 저장
    static int[] answer; // M개의 숫자를 저장
    static boolean[] visited; // 숫자 방문 확인
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 숫자의 개수 N
        M = Integer.parseInt(st.nextToken()); // 수열의 길이 M
        
        arr = new int[N];
        answer = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.print(sb);
        br.close();
    }

    static void dfs(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            // 숫자가 이미 선택된 경우 -> 건너뜀
            if(visited[i]) {
                continue;
            }

            // 숫자 방문 체크 & 숫자 기록(M)
            visited[i] = true;
            answer[depth] = arr[i];
            
            dfs(depth + 1);
            visited[i] = false; // 방문상태 복구(백트래킹)
        }
    }
}
