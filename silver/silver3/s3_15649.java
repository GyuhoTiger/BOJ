package silver.silver3;

import java.util.Scanner;

// 백트래킹
public class s3_15649 {

    static int N, M;
    static int[] arr;
	static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 1 ~ N 까지 범위
        M = sc.nextInt(); // 길이가 M인 수열

        arr = new int[M + 1];
        check = new boolean[N + 1];

        dfs(0); // depth가 0부터 시작
        System.out.print(sb);
        sc.close();
    }

    public static void dfs(int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[depth] = i; // 수열에 현재 위치 숫자 추가
                dfs(depth + 1); // 다음 depth 호출
                check[i] = false;
            }
        }      
    }
}
