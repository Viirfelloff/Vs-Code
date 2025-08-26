package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
// we are NOT getting into silver
public class USACOReflection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int u = sc.nextInt();
        List<List<Integer>> updates = new ArrayList<>();
        List<char[]> rows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rows.add(sc.next().toCharArray());
        }
        for (int j = 0; j < u; j++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            updates.add(Arrays.asList(x,y));
        }

        for (int k = 0; k < updates.size(); k++) {
            int r = updates.get(k).get(0);
            int c = updates.get(k).get(1);
            if (rows.get(r)[c] == '#') {
                rows.get(r)[c] = '.';
            } else {
                rows.get(r)[c] = '#';
            }

        }
    }
    public void countdiffs (List<char[]> painting, int n) {
        for (int l = 0; l < painting.size(); l++) {
            for (int h = 0; h < painting.get(l).length; h++) {
                int r1 = l;
                int c1 = h;
                int r2 = r1;
                int c2 = n - 1 - c1;
                int r3 = n - 1 - r1;
                int c3 = c1;
                int r4 = n - 1 - r1;
                int c4 = n - 1 - c1;
                int diffs = 0;

            }
        }
    }
}
