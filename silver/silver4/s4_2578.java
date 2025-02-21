package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4_2578 {
    static int[][] board = new int[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int call = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                call++;
                int num = Integer.parseInt(st.nextToken());
                delete(num);
                if (check() >= 3) {
                    System.out.println(call);
                    return;
                }
            }
        }
        br.close();
    }

    // 빙고 개수 확인
    private static int check() {
        int count = 0;

        for(int i = 0; i < 5; i++) {
            if (rowBingo(i)) count++;
            if (colBingo(i)) count++;
        }

        if (upBingo()) count++;
        if (downBingo()) count++;

        return count;
    }

    // 사회자가 부른 숫자 지우기
    private static void delete(int num) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(board[i][j] == num) {
                    board[i][j] = 0;
                    return;
                }
            }
        }
    }

    // 행 확인
    private static boolean rowBingo(int row) {
        for(int j = 0; j < 5; j++) {
            if(board[row][j] != 0) return false;
        }
        return true;
    }

    // 열 확인
    private static boolean colBingo(int col) {
        for(int i = 0; i < 5; i++) {
            if(board[i][col] != 0) return false;
        }
        return true;
    }

    // 왼쪽 위 -> 오른쪽 아래 대각선
    private static boolean upBingo() {
        for(int i = 0; i < 5; i++) {
            if(board[i][i] != 0) return false;
        }
        return true;
    }

    // 왼쪽 아래 -> 오른쪽 위 대각선
    private static boolean downBingo() {
        for(int i = 0; i < 5; i++) {
            if(board[4 - i][i] != 0) return false;
        }
        return true;
    }
}
