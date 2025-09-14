package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//def new hardest gah dayum
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
            updates.add(Arrays.asList(x, y));
        }

        int flips = computeFlips(rows, n);
        List<Integer> res = new ArrayList<>();
        res.add(flips);

        for (List<Integer> upd : updates) {
            int r = upd.get(0) - 1;
            int c = upd.get(1) - 1;

            // map to canonical representative in top-left quadrant
            int r0 = Math.min(r, n - 1 - r);
            int c0 = Math.min(c, n - 1 - c);

            // subtract old contribution
            flips -= countdiffs(rows, r0, c0, n);

            // flip the cell
            rows.get(r)[c] = (rows.get(r)[c] == '.') ? '#' : '.';

            // add new contribution
            flips += countdiffs(rows, r0, c0, n);

            res.add(flips);
        }

        for (int val : res) {
            System.out.println(val);
        }
    }

    public static int countdiffs(List<char[]> painting, int r, int c, int n) {
        int r1 = r;
        int c1 = c;
        int r2 = r1;
        int c2 = n - 1 - c1;
        int r3 = n - 1 - r1;
        int c3 = c1;
        int r4 = n - 1 - r1;
        int c4 = n - 1 - c1;
        int zerocount = 0;
        int onecount = 0;
        if (painting.get(r1)[c1] == '.') zerocount++; else onecount++;
        if (painting.get(r2)[c2] == '.') zerocount++; else onecount++;
        if (painting.get(r3)[c3] == '.') zerocount++; else onecount++;
        if (painting.get(r4)[c4] == '.') zerocount++; else onecount++;
        return Math.min(onecount, zerocount);
    }

    public static int computeFlips(List<char[]> pnt, int n) {
        int diff = 0;
        for (int m = 0; m < n / 2; m++) {
            for (int v = 0; v < n / 2; v++) {
                diff += countdiffs(pnt, m, v, n);
            }
        }
        return diff;
    }
}
