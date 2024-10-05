package bronze.bronze3;

import java.util.Scanner;

public class b3_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int fac = 1;

        for(int i = 1; i <= N; i++){
            fac = fac * i;
        }

        System.out.println(fac);
        sc.close();
    }
}
