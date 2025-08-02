package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CodeForcesB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int sum = 0;
        int inc = 0;
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list1.add(sc.nextInt());
        }
        Collections.sort(list1);
        for (int xx : list1) {
            if (sum + xx <= x) {
                sum += xx;
                inc++;
            } else {
                break;  // stop adding because adding xx exceeds x
            }
        }
        System.out.println(inc);
    }
}
