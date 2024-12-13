package silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분 탐색 (하지만 HashSet이 더 좋은듯듯)
public class s5_10815 {
    static int N, M;
    static int[] narr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        narr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(narr); // 이분 탐색을 위한 정렬렬

        M = Integer.parseInt(br.readLine());
        int[] marr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            marr[i] = Integer.parseInt(st.nextToken());
            if(binarySearch(marr[i])) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        } 
        br.close();
    }

    private static boolean binarySearch(int number) {
        int start = 0;
        int end = N - 1;

        while(start <= end){
            int index = (start + end) / 2;
            int mid = narr[index]; // 중간 값으로 비교교

            if(number < mid) {
                end = index - 1;
            } else if (number > mid) {
                start = index + 1;
            } else {
                return true;
            } 
        }
        return false;
    }
}