package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//too easy
public class CodeForces2009A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            List<Integer> cvals = new ArrayList<>();
            for (int m = a; m <= b; m++) {
                cvals.add(m);
            }
            List<Integer> possible = new ArrayList<>();
            for (int c : cvals) {
                possible.add((c - a) + (b - c));
            }
            System.out.println(Collections.min(possible));
        }
    }
}
