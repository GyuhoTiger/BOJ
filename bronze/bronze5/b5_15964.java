package bronze.bronze5;

import java.util.Scanner;

public class b5_15964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        System.out.println((A + B) * (A - B));

        sc.close();
    }
}
