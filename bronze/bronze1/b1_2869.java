package bronze.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class b1_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int days = (V - A) / (A - B); // 달팽이가 정상에 오르기 전날까지의 날
        if((V - A) % (A - B) != 0) // 달팽이가 하루에 오르는 높이보다 정상까지의 높이가 짧을때
            days++;
        System.out.println(days+1);
        br.close();
    }
}
