package LeetCodeAndUSACOProblems;
import java.util.Scanner;

public class CodeForces2044A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i< t; i++) {
            int n = sc.nextInt();
            int count = 0;
            for (int j = 1; j < n; j++) {
                for (int b = 1; b < n; b++) {
                    if (b + j == n) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
