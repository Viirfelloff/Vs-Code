package LeetCodeAndUSACOProblems;
import java.util.Scanner;

public class CodeForces2044 {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int seated = 0;
            int remainingFirstRow = 0;
            int remainingSecondRow = 0;
            if (m > a) {
                seated += a;
                remainingFirstRow = m - a;
            }
            else if (m < a) {
                seated += m;
                remainingFirstRow = 0;
            } else {
                seated += a;
                remainingFirstRow = 0;
            }
            if (m > b) {
                seated += b;
                remainingSecondRow = m - b;
            }
            else if (m < b) {
                seated += m;
                remainingSecondRow = 0;
            } else {
                seated += b;
                remainingSecondRow = 0;
            }
            int totalremaining = remainingSecondRow + remainingFirstRow;
            if (totalremaining < c) {
                seated += totalremaining;
            }
            else if (totalremaining > c) {
                seated += c;
            } else {
                seated += c;
            }
            System.out.println(seated);
        }
    }
}
