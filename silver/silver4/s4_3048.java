package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4_3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        String group1 = br.readLine();
        String group2 = br.readLine();
        int T = Integer.parseInt(br.readLine()); // T초

        int total = N1 + N2;
        char[] ant = new char[total]; // 개미들이 서있는 순서 저장 배열
        int[] dir = new int[total]; // 개미들의 방향을 저장한 배열(1: group1, 2: group2)

        // group1: 뒤집어서 넣기 (오른쪽으로 감)
        for (int i = 0; i < N1; i++) {
            ant[i] = group1.charAt(N1 - 1 - i);
            dir[i] = 1;
        }

        // group2: 그대로 넣기 (왼쪽으로 감)
        for (int i = 0; i < N2; i++) {
            ant[N1 + i] = group2.charAt(i);
            dir[N1 + i] = 2;
        }

        while (T-- > 0) {
            for (int i = 0; i < total - 1; i++) {
                if (dir[i] == 1 && dir[i + 1] == 2) {
                    // 자리 바꾸기
                    char c = ant[i];
                    ant[i] = ant[i + 1];
                    ant[i + 1] = c;

                    int temp = dir[i];
                    dir[i] = dir[i + 1];
                    dir[i + 1] = temp;

                    i++; // 한 쌍만 바꾸므로 다음 칸 건너뛰기
                }
            }
        }

        for (int i = 0; i < ant.length; i++) {
            System.out.print(ant[i]);
        }

        br.close();
    }
}