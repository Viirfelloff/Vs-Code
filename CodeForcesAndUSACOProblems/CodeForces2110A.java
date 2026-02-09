package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//i give up
public class CodeForces2110A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int count = -1;
            List<Integer> nums = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                nums.add(sc.nextInt());
            }
            Collections.sort(nums);
            int min = Collections.min(nums);
            int max = Collections.max(nums);
            if (min % 2 == max % 2) count = 0;
            else {
                int left = 0;
                int right = nums.size() - 1;
                int leftOps = 0;
                int rightOps = 0;
                List<Integer> leftIt = new ArrayList<>(nums);
                while (Collections.min(leftIt) % 2 != Collections.max(leftIt) % 2) {
                    leftIt.remove(Integer.valueOf(leftIt.get(left)));
                    left++;
                    leftOps++;
                }
                List<Integer> rightIt = new ArrayList<>(nums);
                while (Collections.min(rightIt) % 2 != Collections.max(rightIt) % 2) {
                    rightIt.remove(Integer.valueOf(rightIt.get(right)));
                    right--;
                    rightOps++;
                }
                System.out.println(Math.min(rightOps, leftOps));
            }
            System.out.println(count);
        }
    }
}
