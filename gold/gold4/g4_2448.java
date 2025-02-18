package gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분할정복(어렵다...)
public class g4_2448 {
    static String[] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 기본 별모양 저장
        star = new String[N];
		star[0] = "  *  ";
		star[1] = " * * ";
		star[2] = "*****";

        for (int i = 1; 3 * Math.pow(2, i) <= N; ++i) {
			bigStar(i);
		}

		for (int i = 0; i < N; ++i) {
			System.out.println(star[i]);
		}
        br.close();
    }

    // 별 삼각형 확장
    private static void bigStar(int n) {
        int bottom = 3 * (int)Math.pow(2, n);	// 아래 최대 행
        int middle = bottom / 2; // 위와 아래 삼각형 구분하는 행

        // 아래쪽 삼각형
        for (int i = middle; i < bottom; ++i) {
			star[i] = star[i - middle] + " " + star[i -middle];
		}
        
        // 정렬을 위한 공백 생성
        String blank = "";
		while (blank.length() < middle) {
            blank += " ";
		}

        // 위쪽 삼각형 정렬
        for (int i = 0; i < middle; ++i) {
			star[i] = blank + star[i] + blank;
		}
    }
}

