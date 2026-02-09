import java.util.*;

public class CodeForces2065C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            int X = sc.nextInt();

            long prev = Long.MIN_VALUE;
            boolean ok = true;

            for (int i = 0; i < n; i++) {
                long lo = Math.min(a[i], X - a[i]);
                long hi = Math.max(a[i], X - a[i]);

                if (lo >= prev) {
                    prev = lo;
                } else if (hi >= prev) {
                    prev = hi;
                } else {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}
