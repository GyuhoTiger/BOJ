package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4_2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 아이스크림 종류 개수
        int M = Integer.parseInt(st.nextToken()); // 섞으면 안되는 조합 개수

        boolean array[][] = new boolean[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array[a][b] = true;
            array[b][a] = true;
        }

        int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = (i + 1); j <= N; j++) {
				for (int k = (j + 1); k <= N; k++) {
					if (array[i][j] || array[i][k] || array[j][k] || array[j][i] || array[k][i] || array[k][j]) {
						continue;
                    }
					answer++;
				}
            }
        }

        System.out.println(answer);
        br.close();
    }
}