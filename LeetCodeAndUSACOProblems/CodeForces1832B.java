package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1832B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                nums.add(sc.nextInt());
            }
            Collections.sort(nums);
            for (int m = 0; m < k; m++) {
                int x1 = nums.get(0);
                int x2 = nums.get(1);
                int x = x1 + x2;
                if (x > nums.getLast()) {
                    nums.remove(Integer.valueOf(nums.getLast()));
                } else {
                    nums.remove(Integer.valueOf(x1));
                    nums.remove(Integer.valueOf(x2));
                }
            }
            int sum = 0;
            for (int v = 0; v < nums.size(); v++) {
                sum += nums.get(v);
            }
            System.out.println(sum);
        }
    }
}
