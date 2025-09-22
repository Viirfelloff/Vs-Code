package LeetCodeAndUSACOProblems;

import java.util.Scanner;

public class CodeForcesDiv2A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            if ((k - 1) % 3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
