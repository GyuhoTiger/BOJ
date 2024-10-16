package bronze.bronze5;

import java.util.Scanner;

public class b5_27959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        if((N * 100) < M) System.out.print("No");
        else System.out.print("Yes");

        sc.close();
    }
}
