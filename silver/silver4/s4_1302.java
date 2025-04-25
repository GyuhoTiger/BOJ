package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class s4_1302 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
            max = Math.max(max, map.get(book));
        }

        String answer = "";

        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count == max && (answer.equals("") || key.compareTo(answer) < 0)) {
                answer = key;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
