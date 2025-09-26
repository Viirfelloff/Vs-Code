package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces2149B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            List<Integer> diffs = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                nums.add(sc.nextInt());
            }
            Collections.sort(nums);
            for (int k = 0; k < nums.size(); k++) {
                if (k % 2 == 0) {
                    diffs.add(Math.abs(nums.get(k) - nums.get(k + 1)));
                }
            }
            System.out.println(Collections.max(diffs));
        }
    }
}
