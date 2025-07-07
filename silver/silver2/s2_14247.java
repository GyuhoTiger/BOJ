package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_14247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 나무의 개수

        int[] tree = new int[N];
        int[] grow = new int[N];
        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            answer += tree[i]; 
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            grow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(grow);

        for (int i = 0; i < N; i++) {
			answer += grow[i] * i;
		}

        System.out.println(answer);
        br.close();
    }
}