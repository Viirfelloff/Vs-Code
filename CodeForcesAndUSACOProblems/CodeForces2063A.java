package CodeForcesAndUSACOProblems;
import java.util.Scanner;

public class CodeForces2063A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            if (l == r) {
                if (l != 1) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else {
                System.out.println(Math.abs(l - r));
            }
        }
    }
}
