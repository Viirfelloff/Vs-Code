package LeetCodeAndUSACOProblems;

import java.util.Scanner;

public class CodeForcesDiv4B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i< t; i++) {
            int n = sc.nextInt();
            String a = sc.next();
            int m = sc.nextInt();
            String b = sc.next();
            String order = sc.next();
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            int inc = 0;
            for (char c : order.toCharArray()) {
                if (c == 'D') sb.insert(sb.length(), b.charAt(inc));
                else sb.insert(0, b.charAt(inc));
                inc++;
            }
            System.out.println(sb);
        }
    }
}
