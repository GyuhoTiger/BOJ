package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// Hashmap
public class s4_11652 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        long answer = 0;

        HashMap <Long, Integer> map = new HashMap<>();

        // 카드 입력 및 저장
        for(int i = 0; i < N; i++) {
			long card = Long.parseLong(br.readLine());
			map.put(card, map.getOrDefault(card, 0) + 1);
		}

        // 카드 번호의 최대 빈도수
        for(long i : map.keySet()) {
            if(map.get(i) > max) {
                max = map.get(i);
                answer = i;
            }else if(map.get(i) == max) {
                answer = Math.min(i, answer);
            }
        }

        System.out.println(answer);
        br.close();
    }
}
