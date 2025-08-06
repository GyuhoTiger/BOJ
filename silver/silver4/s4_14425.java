package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class s4_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집합의 문자열 갯수 N
        int M = Integer.parseInt(st.nextToken()); // 검사해야할 문자열 개수 M

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}