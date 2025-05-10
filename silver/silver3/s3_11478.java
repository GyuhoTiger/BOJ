package silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class s3_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        // 중복 제거를 위한 HashSet 설정
        Set<String> set = new HashSet<>();

        // 부분 문자열 저장
        for (int i = 0; i <s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                set.add(s.substring(i, j));
            }
        }

        System.out.println(set.size());
        br.close();
    }
}