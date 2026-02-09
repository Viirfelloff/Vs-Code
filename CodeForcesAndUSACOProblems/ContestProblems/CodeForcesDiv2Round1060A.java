
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CodeForcesDiv2Round1060A {
    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            try {
                st = null; // discard remainder of previous line
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next(); // read the binary string

            int moves = 0;
            for (int m = 0; m < n; m++) {
                if (s.charAt(m) == '1') {
                    if (m == 0) {
                        moves++;
                    } else {
                        int start = Math.max(0, m - (k - 1));
                        String sub = s.substring(start, m);
                        if (!sub.contains("1")) {
                            moves++;
                        }
                    }
                }
            }
            System.out.println(moves);
        }
    }
}
