package bronze.bronze5;

import java.math.BigInteger;
import java.util.Scanner;

public class b5_2338 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      BigInteger A = sc.nextBigInteger();
      BigInteger B = sc.nextBigInteger();

        System.out.println(A.add(B));
        System.out.println(A.subtract(B));
        System.out.print(A.multiply(B));

        sc.close();
   } 
}
