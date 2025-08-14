package LeetCodeAndUSACOProblems;

import java.util.Scanner;

//yoo div 3 c problem
public class CodeForcesC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            StringBuilder sb = new StringBuilder();
            int x = sc.nextInt();
            int k = sc.nextInt();
            sb.append(String.valueOf(x).repeat(Math.max(0, k)));
            int newX = Integer.parseInt(sb.toString());
            int factors = 0;
            for (int m = 1; m <= newX; m++) {
                if (newX % m == 0) factors++;
            }
            if (factors == 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
