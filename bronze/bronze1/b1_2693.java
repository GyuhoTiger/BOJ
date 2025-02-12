package bronze.bronze1;

import java.util.Arrays;
import java.util.Scanner;

public class b1_2693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        int[] arr = new int[10];
    
        for(int i = 0; i < T; i++) {
            for(int j = 0; j < 10; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            sb.append(arr[7]).append("\n");
        }
        System.out.println(sb);
    }
}
