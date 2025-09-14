package LeetCodeAndUSACOProblems;

import java.util.*;

public class CodeForces2037A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            List<Integer> nums = new ArrayList<>();
            int n = sc.nextInt();
            boolean[] used = new boolean[n];
            for (int k = 0; k < n; k++) {
                int x = sc.nextInt();
                nums.add(x);
                used[k] = false;
            }
            int score = 0;
            int inc = 0;
            for (int y : nums) {
                if (!used[inc]) {
                    int inc2 = 0;
                    for (int z : nums) {
                        if (inc != inc2 && !used[inc2]) {
                            used[inc] = true;
                            used[inc2] = true;
                            score++;
                            break;
                        }
                        inc2++;
                    }
                }
                inc++;
            }
            res.add(score);
        }
        for (int r : res) {
            System.out.println(r);
        }
    }
}
