package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시의 수 N
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수 d
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수 k
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 c

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        // 번호별 먹은 초밥 확인
        int[] count = new int[d + 1];
        int type = 0;

        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) {
                type++;
            }
            count[sushi[i]]++;
        }

        int max = type;

        if (count[c] == 0) {
            max++;
        }
        
        int start = 1, end = k;
        while (start < N) {
            if (count[sushi[start - 1]] == 1) {
                type--;
            }   
            count[sushi[start - 1]]--;
            
            if (count[sushi[end % N]] == 0) {
                type++;
            }
            count[sushi[end % N]]++;
            
            int total = type;
            if (count[c] == 0) {
                total++;
            }
        
            max = Math.max(max, total);

            start++;
            end++;
        }

        System.out.println(max);
        br.close();
    }
}