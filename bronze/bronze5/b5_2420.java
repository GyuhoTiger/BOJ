package bronze.bronze5;

import java.util.Scanner;

public class b5_2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();
        long M = sc.nextInt();

        System.out.println(Math.abs(N - M));
        sc.close();
    }
}
