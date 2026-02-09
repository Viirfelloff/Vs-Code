package CodeForcesAndUSACOProblems;

import java.util.Scanner;

public class CodeForces1175A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ops = 0;
        while (n != 0) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            ops++;
        }
        System.out.println(ops);
    }
}
