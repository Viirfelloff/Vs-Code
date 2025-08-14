package LeetCodeAndUSACOProblems;

import java.util.Scanner;
//weird ahh problem but ok
public class CodeForces705A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sb.append("I ");
            if (i == n - 1) {
                if (i % 2 == 0) {
                    sb.append("hate ");
                } else {
                    sb.append("love ");
                }
                sb.append("it");
            } else {
                if (i % 2 == 0) {
                    sb.append("hate ");
                } else {
                    sb.append("love ");
                }
                sb.append("that ");
            }
        }
        System.out.println(sb.toString());
    }
}
