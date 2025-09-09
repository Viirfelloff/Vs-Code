package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USACOSleepingInClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> times = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                times.add(sc.nextInt());
            }
        }
    }
}
