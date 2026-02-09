package CodeForcesAndUSACOProblems.ContestProblems;

import java.util.Scanner;

public class CodeForcesDiv22166A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            char last = s.charAt(s.length() - 1);
            int ops = 0;
            for (char c : s.toCharArray()) {
                if (c != last) ops++;
            }
            System.out.println(ops);
        }
    }
}
