package LeetCodeAndUSACOProblems;
import java.util.*;

public class CodeForces2143A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] perm = new int[n];
            for (int i = 0; i < n; i++) perm[i] = sc.nextInt();

            // find position of n
            int pos = -1;
            for (int i = 0; i < n; i++) {
                if (perm[i] == n) { pos = i; break; }
            }

            if (pos == -1) { // just in case (shouldn't happen for valid permutation)
                System.out.println("NO");
                continue;
            }

            int left = pos, right = pos;
            int cur = n - 1;
            while (cur >= 1) {
                if (left - 1 >= 0 && perm[left - 1] == cur) {
                    left--;
                } else if (right + 1 < n && perm[right + 1] == cur) {
                    right++;
                } else {
                    break;
                }
                cur--;
            }

            System.out.println(cur == 0 ? "YES" : "NO");
        }
        sc.close();
    }
}
