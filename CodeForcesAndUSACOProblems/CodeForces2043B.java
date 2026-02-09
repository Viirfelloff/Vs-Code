package CodeForcesAndUSACOProblems;

import java.util.Scanner;

public class CodeForces2043B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            int d = sc.nextInt();
            System.out.println(1);
            if (n >= 3) System.out.println(3);
            if (d == 5) System.out.println(5);
            if (n >= 6) System.out.println(9);
        }
    }
}
