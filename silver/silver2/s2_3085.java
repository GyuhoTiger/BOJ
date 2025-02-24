package silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 브루트포스 알고리즘
public class s2_3085 {
    static int N;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int max = 0; // 초깃값 0
        candy(); // 아무것도 바꾸지 않은 상태에서도 최댓값 존재가능하므로 행/열검사 실행

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 오른쪽과 바꾸기
                if(j + 1 < N) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, candy());
                    swap(i, j, i, j + 1); // 원상복구
                }

                // 아래쪽과 바꾸기
                if(i + 1 < N) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, candy());
                    swap(i, j, i + 1, j);
                }
            }
        }
   
        System.out.println(max);
        br.close();
    }

    // 위치 교환 함수
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static int candy() {
        int maxCount = 0;

        // 행 검사
        for(int i = 0; i < N; i++) {
            int count = 1;
            for(int j = 1; j < N; j++) {
                if(board[i][j] == board[i][j - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        // 열 검사
        for(int j = 0; j < N; j++) {
            int count = 1;
            for(int i = 1; i < N; i++) {
                if(board[i][j] == board[i - 1][j]) {
                    count++;
                } else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
