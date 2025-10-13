import java.util.*;
import java.io.*;
//UR A FUCKING FAILURE, UR NEVER GETTING 1200 RATED PROLBLEMS. U SUCK AT CP.
public class CodeForces2117D {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = fs.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = fs.nextLong();

            if (n == 2) {
                long a1 = a[0], a2 = a[1];
                long numer = 2 * a1 - a2;
                if (numer % 3 == 0) {
                    long y = numer / 3;
                    long x = a1 - 2 * y;
                    sb.append((x >= 0 && y >= 0) ? "YES\n" : "NO\n");
                } else {
                    sb.append("NO\n");
                }
            } else {
                boolean ok = true;
                long diff = a[1] - a[0];
                for (int i = 2; i < n; i++) {
                    if (a[i] - a[i-1] != diff) {
                        ok = false;
                        break;
                    }
                }
                sb.append(ok ? "YES\n" : "NO\n");
            }
        }
        System.out.print(sb.toString());
    }

    // fast scanner for competitive programming
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return Long.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }
}
