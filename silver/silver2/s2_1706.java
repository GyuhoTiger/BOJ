package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class s2_1706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()); // R개의 줄
        int C = Integer.parseInt(st.nextToken()); // C개의 알파벳

        char[][] arr = new char[R][C];

        for(int i = 0; i < R; i++) {
            String row = br.readLine();
            for(int j = 0; j < C; j++) {
                arr[i][j] = row.charAt(j);
            }
        }

        TreeSet<String> word = new TreeSet<>();

        // 가로 방향
        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < C; j++) {
                char ch = arr[i][j];
                if(ch != '#') {
                    sb.append(ch);
                } else {
                    if(sb.length() >= 2) {
                        word.add(sb.toString());
                    }
                    sb.setLength(0); // 초기화
                }
            }
            if(sb.length() >= 2) {
                word.add(sb.toString());
            }
        }

        // 세로 방향
        for(int i = 0; i < C; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < R; j++) {
                char ch = arr[j][i];
                if (ch != '#') {
                    sb.append(ch);
                } else {
                    if (sb.length() >= 2) {
                        word.add(sb.toString());
                    }
                    sb.setLength(0);
                }
            }
            if (sb.length() >= 2) {
                word.add(sb.toString());
            }
        }

        System.out.println(word.first());
        br.close();
    }
}
