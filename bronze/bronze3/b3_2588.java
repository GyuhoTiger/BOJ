package bronze.bronze3;

import java.util.Scanner;

public class b3_2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println(N * (M % 10));
        System.out.println(N * ((M % 100) / 10));
        System.out.println(N * (M / 100));
        System.out.println(N * M);

        sc.close();
    }
}
