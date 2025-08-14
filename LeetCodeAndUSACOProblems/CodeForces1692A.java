package LeetCodeAndUSACOProblems;

import java.util.Scanner;
//focus on div 2 A-c problems.
public class CodeForces1692A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int res = 0;
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            if (a < b) res++;
            else if (a < c) res++;
            else if (a < d) res++;
            System.out.println(res);
        }
    }
}
