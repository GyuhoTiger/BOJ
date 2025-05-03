package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_6603 {
    static int T;
    static int[] arr;
    static int[] result = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            
            if (T == 0) {
                break;
            }

            arr = new int[T];
            for (int i = 0; i < T; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println();
        }
        br.close();
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < T; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }
}