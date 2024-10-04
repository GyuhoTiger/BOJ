package bronze.bronze5;

import java.util.Scanner;

public class b5_27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        int INDEX = sc.nextInt();

        System.out.print(S.charAt(INDEX - 1));

        sc.close();
    }
}
