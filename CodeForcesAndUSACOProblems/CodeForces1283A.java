package CodeForcesAndUSACOProblems;

import java.util.Scanner;

public class CodeForces1283A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int maxtime = 24*60;
            int h = sc.nextInt();
            int m = sc.nextInt();
            m += 60*h;
            System.out.println(Math.abs(maxtime - m));
        }
    }
}
