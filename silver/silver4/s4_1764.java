package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

//Hashmap (10816 참고)
public class s4_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> result = new ArrayList<String>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1); // default : 0, key값 + 1
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1); // 해당 키 값 반환
            if(map.get(key) == 2) {
                count++;
                result.add(key);
            }
        }

        Collections.sort(result);

        sb.append(count).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}
