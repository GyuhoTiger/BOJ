package bronze.bronze5;

import java.util.Scanner;

public class b5_27433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long sum = 1;
        if(N == 0) {
            System.out.print((sum));
        }
        else {
            for(int i = 1; i <= N; i++) {
                sum = sum * i;
            }
            System.out.print((sum));
        }
        sc.close();
    }
}