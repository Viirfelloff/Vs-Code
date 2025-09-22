package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1883A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int j = 1; j < 10; j++) {
            arr.add(j);
        }
        arr.add(0);
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            int total = 0;
            total += Math.abs(arr.indexOf(1) - Integer.valueOf(s.charAt(0)));
            for (int n = 0; n < 3; n++) {
                total += Math.abs(arr.indexOf(Integer.valueOf(s.charAt(n))) - arr.indexOf(Integer.valueOf(s.charAt(n + 1))));
            }
            total += 4;
            System.out.println(total);
        }
    }
}
