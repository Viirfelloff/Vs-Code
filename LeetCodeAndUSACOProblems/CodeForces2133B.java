import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces2133B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> nums = new ArrayList<>();
            for (int k = 0; k < n; k++) nums.add(sc.nextLong());
            Collections.sort(nums);
            long res = 0;
            List<int[]> pairs = new ArrayList<>();
            // simulate initial pairs
            if (n % 2 != 0) {
                for (int j = 0; j < n - 1; j += 2) {
                    res += Math.max(nums.get(j), nums.get(j + 1));
                    long dec = Math.min(nums.get(j), nums.get(j + 1));
                    nums.set(j, nums.get(j) - dec);
                    nums.set(j + 1, nums.get(j + 1) - dec);
                    pairs.add(new int[]{j, j + 1});
                }
            } else {
                for (int j = 0; j < n; j += 2) {
                    res += Math.max(nums.get(j), nums.get(j + 1));
                    long dec = Math.min(nums.get(j), nums.get(j + 1));
                    nums.set(j, nums.get(j) - dec);
                    nums.set(j + 1, nums.get(j + 1) - dec);
                    pairs.add(new int[]{j, j + 1});
                }
            }
            // connect pairs
            if (pairs.size() != 1) {
                for (int l = 0; l + 1 < pairs.size(); l += 2) { // ✅ fixed condition
                    long min1 = 0;
                    int minDex1 = 0;
                    if (nums.get(pairs.get(l)[0]) > nums.get(pairs.get(l)[1])) {
                        minDex1 = pairs.get(l)[1];
                        min1 = nums.get(pairs.get(l)[1]);
                    } else {
                        minDex1 = pairs.get(l)[0];
                        min1 = nums.get(pairs.get(l)[0]);
                    }
                    long min2 = 0;
                    int minDex2 = 0;
                    if (nums.get(pairs.get(l + 1)[0]) > nums.get(pairs.get(l + 1)[1])) {
                        minDex2 = pairs.get(l + 1)[1];
                        min2 = nums.get(pairs.get(l + 1)[1]);
                    } else {
                        minDex2 = pairs.get(l + 1)[0];
                        min2 = nums.get(pairs.get(l + 1)[0]);
                    }
                    long max = Math.max(min1, min2);
                    long min = Math.min(min1, min2);
                    res += max;
                    nums.set(minDex1, nums.get(minDex1) - min);
                    nums.set(minDex2, nums.get(minDex2) - min);
                }
            }
            // deal w leftover (only if odd)
            if (n % 2 != 0) {
                res += nums.get(nums.size() - 1);
            }
            System.out.println(res);
        }
    }
}
