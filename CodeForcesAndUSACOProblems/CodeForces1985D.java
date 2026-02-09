package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1985D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            List<String> rows = new ArrayList<>();
            for (int j = 0; j < r; j++) {
                rows.add(sc.next());
            }
            int[] res = getInts(r, c, rows);
            int inc = 0;
            for (int y : res) {
                System.out.println(res[inc]);
                inc++;
            }
        }
    }

    private static int[] getInts(int r, int c, List<String> rows) {
        int[] up = new int[2];
        for (int m = 0; m < r; m++) {
            for (int n = 0; n < c; n++) {
                if (rows.get(m).charAt(n) == '#') {
                    up = new int[] {m + 1, n + 1};
                    break;
                }
            }
        }
        int[] down = new int[2];
        for (int b = r - 1; b >= 0; b--) {
            for (int v = 0; v < c; v++) {
                if (rows.get(b).charAt(v) == '#') {
                    down = new int[]{b + 1, v + 1};
                    break;
                }
            }
        }
        int[] res = new int[]{((down[0] + up[0]) / 2), down[1]};
        return res;
    }
}
