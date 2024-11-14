package silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s4_1018 {
    public static String map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // N : 행, M : 열
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map= new String[N][M];
        
        // 체스판 입력
        for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				if(str.charAt(j) == 'W') {
					map[i][j] = "W";
				} else {
					map[i][j] = "B";
				}
			}
		}

        // 자르는 규칙
        int row = (N - 7);
		int col = (M - 7);
        int min = 64;
 
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				min = Math.min(min, cut(i, j));
			}
		}
		System.out.println(min);
        br.close();
	}

    public static int cut(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;
 
		String color = "W";
 
		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {
 
				// 올바른 색이 아닐경우 count 1 증가 
				if (!map[i][j].equals(color)) {	
					count++;
				}
				
				if(color.equals("W")) {
                    color = "B";
                } else {
                    color = "W";
                }
			}

            if(color.equals("W")) {
                color = "B";
            } else {
                color = "W";
            }
		}
		count = Math.min(count, 64 - count);
        return count;
	}
}
