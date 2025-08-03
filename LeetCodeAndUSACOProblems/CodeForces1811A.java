package LeetCodeAndUSACOProblems;

import java.util.Scanner;
//yet another failure
public class CodeForces1811A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // length of number
            int d = sc.nextInt(); // digit to insert
            String s = sc.next(); // number as string

            StringBuilder sb = new StringBuilder();
            boolean inserted = false;

            for (int i = 0; i < n; i++) {
                int digit = s.charAt(i) - '0';
                if (!inserted && d > digit) {
                    sb.append(d);
                    inserted = true;
                }
                sb.append(s.charAt(i));
            }

            if (!inserted) {
                sb.append(d); // insert at the end
            }

            System.out.println(sb.toString());
        }
    }
}
