package LeetCodeAndUSACOProblems;

import java.util.Scanner;

public class CodeForces2072A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); //number of zeroes
            int k = sc.nextInt(); //target
            int p = sc.nextInt(); //to add
            int[] arr = new int[n];
            if (n * p < k || n * -p > k || p > k) System.out.println("-1");
            else {

            }
        }
    }
}
