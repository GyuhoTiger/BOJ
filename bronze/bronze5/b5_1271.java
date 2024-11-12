package bronze.bronze5;

import java.math.BigInteger;
import java.util.Scanner;

public class b5_1271 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger N = sc.nextBigInteger();
        BigInteger M = sc.nextBigInteger();

        System.out.println(N.divide(M));
        System.out.println(N.remainder(M));

        sc.close();
    }
}
