import java.io.*;
import java.util.*;

public class USACOSleepingInClass {
    static FastScanner in;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(System.out);

        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            int[] a = new int[N];
            long sum = 0;
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
                sum += a[i];
            }

            // special case: all zeros
            if (sum == 0) {
                out.println(0);
                continue;
            }

            int ans = N - 1; // worst case: merge everything into one group
            // iterate over divisors of sum
            for (long d = 1; d * d <= sum; d++) {
                if (sum % d == 0) {
                    ans = Math.min(ans, check(a, (int) d, N));
                    ans = Math.min(ans, check(a, (int) (sum / d), N));
                }
            }

            out.println(ans);
        }

        out.flush();
    }

    // check if we can partition into groups of sum target
    static int check(int[] a, int target, int N) {
        int groups = 0;
        int curr = 0;
        for (int x : a) {
            curr += x;
            if (curr > target) return N - 1; // impossible, return large value
            if (curr == target) {
                groups++;
                curr = 0;
            }
        }
        if (curr != 0) return N - 1; // not perfectly partitioned
        return N - groups;
    }

    // FastScanner for fast input
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
