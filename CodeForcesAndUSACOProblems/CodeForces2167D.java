package CodeForcesAndUSACOProblems;

import java.util.Scanner;

public class CodeForces2167D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long minimum = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                if (minimum > x) minimum = x;
            }
            long minDivisor = -1;
            for (long k = 0; k < minimum; k++) {

            }
        }
    }
}
