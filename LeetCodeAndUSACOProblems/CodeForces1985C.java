package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//i fucking give up
public class CodeForces1985C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> prefix = new ArrayList<>();
            int inc = 0;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                prefix.add(x);
                sum += x;
                if (2 * Collections.max(prefix) == sum) inc++;
            }
            System.out.println(inc);
        }
    }
}
