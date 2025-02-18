package silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분할정복
public class s1_1992 {

    public static char[][] video;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        video = new char[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                video[i][j] = line.charAt(j);
            }
        }

        divide(0,0,N);
        System.out.println(sb);
        br.close();
    }

    // 분할
    public static void divide(int x, int y, int size) {
        if(check(x, y, size)) {
            sb.append(video[x][y]);
            return;
        }

        sb.append("(");

        int temp = size / 2;

        divide(x, y, temp); // 왼쪽 위
        divide(x, y + temp, temp); // 오른쪽 위
        divide(x + temp, y, temp); // 왼쪽 아래
        divide(x + temp, y + temp, temp); // 오른쪽 아래

        sb.append(")");
    }

    // 압축 가능 판독
    public static boolean check(int x, int y, int size) {
        int point = video[x][y];

        // 시작지점과 비교해서 만약 다르면 압축 불가능
        for(int i = x; i < (x + size); i++) {
            for(int j = y; j < (y + size); j++) {
                if(point != video[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
