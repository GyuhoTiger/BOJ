package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int len = S.length();

        // 특정 알파벳의 등장 빈도수
        int[][] arr = new int[26][len + 1];

        for (int i = 0; i < len; i++){
            int ch = S.charAt(i) - 'a';
            for(int j = 0; j < 26; j++){
                arr[j][i + 1] = arr[j][i];
            }
            arr[ch][i + 1]++;
        }

        int Q = Integer.parseInt(br.readLine()); // 질문의 수 Q
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            String[] part = br.readLine().split(" ");
            char target = part[0].charAt(0);
            int l = Integer.parseInt(part[1]); // 왼쪽 구간 l
            int r = Integer.parseInt(part[2]); // 오른쪽 구간 r

            int index = target - 'a';
            int count = arr[index][r + 1] - arr[index][l];
            sb.append(count).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}