

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//ur utterly cooked. cant solve a singular problem.
public class CodeForces2123C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                nums.add(sc.nextInt());
            }
            int inc = 0;
            for (int x : nums) {
                if (inc == 0) {
                    if (Collections.min(nums) == x) sb.append(1);
                    else sb.append(0);
                }
                else if (inc == n - 1)  {
                    if (Collections.max(nums) == x) sb.append(1);
                    else sb.append(0);
                } else {
                    List<Integer> subLeft = new ArrayList<>(nums.subList(0, inc));
                    List<Integer> subRight = new ArrayList<>(nums.subList(inc + 1, n));
                    int leftMin = Collections.min(subLeft);
                    int rightMax = Collections.max(subRight);
                    if (x <= leftMin && x >= rightMax) sb.append(1);
                    else sb.append(0);
                }
                inc++;
            }
            System.out.println(sb);
        }
    }
}
