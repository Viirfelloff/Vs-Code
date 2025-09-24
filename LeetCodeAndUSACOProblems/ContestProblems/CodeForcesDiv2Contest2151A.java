package LeetCodeAndUSACOProblems.ContestProblems;
import java.io.*;
import java.util.*;

public class CodeForcesDiv2Contest2151A {
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

        String nextLine() {
            try {
                st = null; // discard remainder of previous line
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        int nextInt() {
            String s = next();
            if (s == null) throw new NoSuchElementException();
            return Integer.parseInt(s);
        }

        long nextLong() {
            String s = next();
            if (s == null) throw new NoSuchElementException();
            return Long.parseLong(s);
        }

        double nextDouble() {
            String s = next();
            if (s == null) throw new NoSuchElementException();
            return Double.parseDouble(s);
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        // Read matrix of ints
        int[][] nextIntMatrix(int n, int m) {
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) mat[i][j] = nextInt();
            return mat;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = fs.nextInt();
        for (int i = 0; i < t;i++) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            List<Integer> list = new ArrayList<>();
            int onecount = 0;
            for (int j = 0; j < m; j++) {
                int x = fs.nextInt();
                list.add(x);
                if (x == 1) onecount++;
            }
            if (list.size() == 1) {
                out.println(n - list.get(0) + 1);
            }
            else if (onecount > 1) {
                out.println(1);
            } else {
                boolean increasing = true;
                int inc = 0;
                for (int xx : list) {
                    if (inc != 0) {
                        if (xx - list.get(inc - 1) != 1) {
                            increasing = false;
                            break;
                        }
                    }
                    inc++;
                }
                if (!increasing) {
                    out.println(1);
                } else {
                    out.println(n - Collections.max(list) + 1);
                }
            }
        }

        out.close();
    }
}
