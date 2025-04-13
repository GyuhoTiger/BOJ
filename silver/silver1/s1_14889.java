package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트래킹
public class s1_14889 {
    static int N;
	static int[][] arr;
	static boolean[] visit;
    static int min = Integer.MAX_VALUE; // 능력치 차이의 최소값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 인원 수 N
		arr = new int[N][N]; // i와 j번의 능력치
		visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
        br.close();
    }

    static void dfs(int index, int count) { // index : 번호, count : 사람 수
        if (count == N / 2) {
            int start = 0;
            int link = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visit[i] && visit[j]) {
                        start += arr[i][j] + arr[j][i]; // i, j가 다 start 팀
                    } else if (!visit[i] && !visit[j]) {
                        link += arr[i][j] + arr[j][i]; //  i, j가 다 link 팀
                    }
                }
            }

            int diff = Math.abs(start - link);
            // 능력치 차이 = 0 일경우
            if (diff == 0) {
                System.out.println(0);
                System.exit(0);
            }

            min = Math.min(min, diff);
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }
}