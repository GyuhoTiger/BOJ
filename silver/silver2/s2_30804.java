package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 투 포인터
public class s2_30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] tanghulu = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            tanghulu[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, answer = 0;

        for(int end = 0; end < N; end++) {
            map.put(tanghulu[end], map.getOrDefault(tanghulu[end], 0) + 1); // 과일 종류 추가

            // 과일 종류가 3 이상이면 start 포인터 이동해서 map에서 제거
            while(map.size() > 2) {
                map.put(tanghulu[start], map.get(tanghulu[start]) - 1);
                if(map.get(tanghulu[start]) == 0) {
                    map.remove(tanghulu[start]);
                }
                start++;
            }
            answer = Math.max(answer, end - start + 1);
        }

        System.out.println(answer);
        br.close();
    }
}
