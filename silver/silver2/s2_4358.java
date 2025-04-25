package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s2_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        while (true) {
            String tree = br.readLine();

            if (tree == null || tree.isEmpty()) {
                break;
            }

            map.put(tree, map.getOrDefault(tree, 0) + 1);
            count++;

        }

        // map의 entry들을 리스트로 바꾼 후 key 기준 정렬(구글링)
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> a.getKey().compareTo(b.getKey()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            double percent = (entry.getValue() * 100.0) / count;
            sb.append(String.format("%s %.4f\n", entry.getKey(), percent)); // 소수점 4번째자리까지 반올림해 출력
        }

        System.out.print(sb);
        br.close();
    }
}