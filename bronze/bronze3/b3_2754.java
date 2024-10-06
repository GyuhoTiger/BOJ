package bronze.bronze3;

import java.util.Scanner;

public class b3_2754 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Grade = sc.next();

        switch (Grade) {
            case "A+":
                System.out.print("4.3");
                break;
            case "A0":
                System.out.print("4.0");
                break;
            case "A-":
                System.out.print("3.7");
                break;
            case "B+":
                System.out.print("3.3");
                break;
            case "B0":
                System.out.print("3.0");
                break;
            case "B-":
                System.out.print("2.7");
                break;
            case "C+":
                System.out.print("2.3");
                break;
            case "C0":
                System.out.print("2.0");
                break;
            case "C-":
                System.out.print("1.7");
                break;
            case "D+":
                System.out.print("1.3");
                break;
            case "D0":
                System.out.print("1.0");
                break;
            case "D-":
                System.out.print("0.7");
                break;
            case "F":
                System.out.print("0.0");
                break;
            default:
                break;
        }
        sc.close();
    }
}
