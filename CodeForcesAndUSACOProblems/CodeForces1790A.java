package CodeForcesAndUSACOProblems;

import java.util.Scanner;

public class CodeForces1790A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            double pi = Math.PI;
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == String.valueOf(pi).charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
