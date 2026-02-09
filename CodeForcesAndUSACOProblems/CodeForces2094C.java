package CodeForcesAndUSACOProblems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeForces2094C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i =0; i< t;i++) {
            int n = sc.nextInt();
            Set<Integer> seen = new HashSet<>();
            int[] res = new int[n * 2];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    int x = sc.nextInt();
                    if (!seen.contains(x)) {
                        seen.add(x);
                        res[(j + k) - 1] = x;
                    }
                }
            }
            int missing = 0;
            for (int m = 1; m <= n * 2; m++) {
                if (!seen.contains(m)) {
                    missing = m;
                    break;
                }
            }
            for (int b = 0; b < 2*n; b++) {
                if (res[b] == 0) {
                    res[b] = missing;
                }
            }
            for (int xx : res) {
                System.out.println(xx);
            }
        }
    }
}
