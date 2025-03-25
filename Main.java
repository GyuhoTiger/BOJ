import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP, Knapsack
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 활성화 되어있는 앱의 개수 N (1 <= N <= 100)
        int M = Integer.parseInt(st.nextToken()); // 필요한 메모리 M 바이트 (1 <= M <= 10000000)

        int[] memory = new int[N + 1]; // 앱의 메모리
		int[] cost = new int[N + 1]; // 앱을 비활성화 하는데 드는 비용

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

        // 비용당 확보 가능한 최대 메모리 -> 비용의 총합의 최댓값이 10000
        int[][] dp = new int[N + 1][10001];
        int answer = Integer.MAX_VALUE;


        // 예) dp[3][4] = 50 : 3번째 앱까지 고려해서 비용 4를 써서 50메모리 
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 10000; j++) {
                // 비용 j가 앱의 비용 c보다 작으면 선택 불가하기 때문에 이전 상태를 불러옴
                if (j < cost[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]); // 선택하지 않거나 or 선택
                }

                if (dp[i][j] >= M) {
                    answer = Math.min(answer, j);
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}