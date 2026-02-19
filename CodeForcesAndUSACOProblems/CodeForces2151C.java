import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//genuinelky stroke of genius bro precomputation to the rescue LES GOOOO
public class CodeForces2151C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> times = new ArrayList<>();
            for (int j = 0; j < 2*n; j++) times.add(sc.nextLong());
            List<Long> enddiffs = new ArrayList<>();
            int p1 = 0;
            int p2 = (2 * n) - 1;
            long curdiff = 0;
            for (int j = 1; j <= n; j++) {
                curdiff += Math.abs(times.get(p1) - times.get(p2));
                p1++;
                p2--;
                enddiffs.add(curdiff);
            }
            List<Long> adjEven = new ArrayList<>();
            long curesum = 0;
            for (int j = 0; j < 2*n; j++) {
                if (j % 2 == 0) {
                    curesum += Math.abs(times.get(j) - times.get(j + 1));
                }
                adjEven.add(curesum);
            }
            List<Long> adjOdd = new ArrayList<>();
            long curosum = 0;
            for (int j = 1; j < (2*n) - 1; j++) {
                if (j % 2 != 0) {
                    curosum += Math.abs(times.get(j) - times.get(j + 1));
                }
                adjOdd.add(curosum);
            }
            for (int k = 1; k <= n; k++) {
                if (k == 1) {
                    System.out.println(adjEven.get(adjEven.size() - 1));
                } else {
                    long ans = enddiffs.get(k - 2);
                    if (k % 2 == 0) {
                        int l = k - 2;
                        int r = adjOdd.size() - 1 - (k - 2);
                        if (l <= r) {
                            long rangeSum = adjOdd.get(r) - (l > 0 ? adjOdd.get(l - 1) : 0);
                            ans += rangeSum;
                        }
                    } else {
                        int l = k - 1;
                        int r = adjEven.size() - 1 - (k - 1);
                        if (l <= r) {
                            long rangeSum = adjEven.get(r) - (l > 0 ? adjEven.get(l - 1) : 0);
                            ans += rangeSum;
                        }
                    }
                    System.out.println(ans);
                }
            }
        }
    }
}
