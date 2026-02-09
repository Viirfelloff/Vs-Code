import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesRound1076C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                a.add(sc.nextInt());
            }
            List<Integer> b = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                b.add(sc.nextInt());
            }
            //idea: precompute - what is the largest value we can get at an index
            //from either pulling from b or moving values left?
            //then, construct prefix sum array
            //for each query use pfs to get answer
            int rMax = 0;
            int[] best = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                rMax = Math.max(rMax, Math.max(a.get(j), b.get(j)));
                best[j] = rMax;
            }
            long[] pfs = new long[n + 1];
            pfs[0] = 0;
            for (int jj = 1; jj <= n; jj++) {
                pfs[jj] = pfs[jj - 1] + best[jj - 1];
            }
            for (int j = 0; j < q; j++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(pfs[r] - pfs[l - 1]);
            }
        }
    }
}
