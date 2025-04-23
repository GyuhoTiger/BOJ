package gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4_9177 {
    static String A, B, C;
    static Boolean[][] visit; // 방문 저장 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = st.nextToken();
            C = st.nextToken();

            // 길이가 A + B != C 인경우 : no 
            if (A.length() + B.length() != C.length()) {
                System.out.println("Data set " + i + ": no");
                continue;
            }

            visit = new Boolean[A.length() + 1][B.length() + 1];

            if (dfs(0, 0)) {
                System.out.println("Data set " + i + ": yes");
            } else {
                System.out.println("Data set " + i + ": no");
            }
        }

        br.close();
    }

    // A 문자열의 i번째 문자부터 B 문자열의 j번째 문자까지
    public static boolean dfs(int i, int j) {

        if (i + j == C.length()) {
            return true;
        }

        if (visit[i][j] != null) {
            return visit[i][j];
        }
        
        boolean result = false;

        if (i < A.length() && A.charAt(i) == C.charAt(i + j)) {
            result = dfs(i + 1, j);
        }

        if (!result && j < B.length() && B.charAt(j) == C.charAt(i + j)) {
            result = dfs(i, j + 1);
        }

        visit[i][j] = result;
        return result;
    }
}
