package LeetCodeAndUSACOProblems.ContestProblems;
import java.io.*;
import java.util.*;

public class CodeForcesDiv2Contest2151B {

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
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            String ops = fs.next();
            TreeSet<Long> black = new TreeSet<>();
            for (int i = 0; i < m; i++) black.add(fs.nextLong());

            long pos = 1;
            for (char c : ops.toCharArray()) {
                if (c == 'A') {
                    pos += 1;
                } else { // B command
                    Long nextBlack = black.higher(pos);
                    if (nextBlack == null) pos += 1; // next white cell is just next cell
                    else pos = nextBlack - 1;        // next white cell before next black
                }
                black.add(pos);
            }

            out.println(black.size());
            for (long x : black) out.print(x + " ");
            out.println();
        }

        out.flush();
        out.close();
    }
}

