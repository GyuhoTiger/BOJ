package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// LinkedHashMap : 입력 순서를 유지하면서 빈도수 저장 가능한 해시맵
public class s3_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            map.put(number, map.getOrDefault(number, 0) + 1); // 각 숫자에 대한 빈도수 증가 및 저장, 디폴트 : 0
        }

        // Map -> List로 변환, Map을 List처럼 다룰 수 있게됨, (Key / value) 쌍을 Set으로 반환
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue(); // 빈도수를 기준으로 내림차순 정렬
            }
        });

        for(int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            int key = entry.getKey();
            int value = entry.getValue();
            // 숫자의 빈도수만큼 반복
            for (int j = 0; j < value; j++) {
                sb.append(key).append(" ");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
