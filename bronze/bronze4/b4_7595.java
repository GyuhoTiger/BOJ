package bronze.bronze4;

import java.util.Scanner;

public class b4_7595 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
