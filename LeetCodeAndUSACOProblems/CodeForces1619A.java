package LeetCodeAndUSACOProblems;

import java.util.Scanner;

public class CodeForces1619A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            if (s.length() % 2 != 0) System.out.println("NO");
            else {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                int index = s.length() / 2;
                for (int j = 0; j < index; j++) {
                    sb1.append(s.charAt(j));
                }
                for (int in = index; in < s.length(); in++) {
                    sb2.append(s.charAt(in));
                }
                if (sb1.toString().contentEquals(sb2)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
