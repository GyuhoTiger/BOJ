package bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3_30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] size = new int[6];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++){
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int count = 0;

        for(int i = 0; i < 6; i++){
            if(size[i] % T != 0){
                count += (size[i] / T + 1);
            } else {
                count += size[i] / T;
            }
        }
        System.out.println(count);
        System.out.print((N / P) + " " + N % P);
        br.close();
    }
}