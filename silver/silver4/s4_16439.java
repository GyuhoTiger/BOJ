package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4_16439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] chicken = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                chicken[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    int total = 0;
                    for (int n = 0; n < N; n++) {
                        int best = Math.max(chicken[n][i], Math.max(chicken[n][j], chicken[n][k]));
                        total += best;
                    }
                    if (total > max) {
                        max = total;
                    }
                }
            }
        }

        System.out.println(max);
        br.close();
    }
}