package LeetCodeAndUSACOProblems;

import java.util.*;
//TODO: finish implementation 9/30
//finally gaining some confidence back
public class CodeForces2121C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Set<Integer> total = new HashSet<>();
            List<List<Integer>> lists = new ArrayList<>();
            int[] rows = new int[n];
            int[] cols = new int[m];
            for (int k = 0; k < n; k++) {
                List<Integer> frig = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    int x = sc.nextInt();
                    frig.add(x);
                    total.add(x);
                }
                lists.add(frig);
            }
            int max = Collections.max(total);
            int inc1 = 0;
            for (List<Integer> list : lists) {
                int inc2 = 0;
                for (int y : list) {
                    if (y == max) {
                        rows[inc1] = rows[inc1] + 1;
                        cols[inc2] = cols[inc2] + 1;
                    }
                    inc2++;
                }
                inc1++;
            }

        }
    }
}
