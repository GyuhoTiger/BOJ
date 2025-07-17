package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class s4_9322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수 T

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 한 문장의 단어 개수 N

            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] key1 = new String[N];
            for (int j = 0; j < N; j++) {
                key1[j] = st.nextToken();
            }

            st = new StringTokenizer(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < N; j++) {
                map.put(st.nextToken(), j);
            }

            st = new StringTokenizer(br.readLine());
            String[] password = new String[N];
            for (int j = 0; j < N; j++) {
                password[j] = st.nextToken();
            }

            String[] result = new String[N];
            for (int j = 0; j < N; j++) {
                int index = map.get(key1[j]);
                result[j] = password[index];
            }

            for (String word : result) {
                System.out.print(word + " ");
            }

            System.out.println();
        }

        br.close();
    }
}