package bronze.bronze5;

import java.math.BigInteger;
import java.util.Scanner;

public class b5_15740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        System.out.print(a.add(b));
        sc.close();
    }
}