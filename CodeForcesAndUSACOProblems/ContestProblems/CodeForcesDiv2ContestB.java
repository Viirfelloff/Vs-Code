package CodeForcesAndUSACOProblems.ContestProblems;
import java.io.*;
import java.util.*;

public class CodeForcesDiv2ContestB {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            int[] count = new int[m + 1]; // count how many sets contain number i
            int[][] sets = new int[n][];

            for (int i = 0; i < n; i++) {
                int l = fs.nextInt();
                sets[i] = new int[l];
                for (int j = 0; j < l; j++) {
                    sets[i][j] = fs.nextInt();
                    count[sets[i][j]]++;
                }
            }

            boolean impossible = false;
            for (int i = 1; i <= m; i++) {
                if (count[i] == 0) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                out.println("NO");
                continue;
            }

            boolean hasUnique = false;
            for (int i = 0; i < n; i++) {
                int unique = 0;
                for (int x : sets[i]) {
                    if (count[x] == 1) unique++;
                }
                if (unique <= 1) hasUnique = true;
            }

            out.println(hasUnique ? "YES" : "NO");
        }

        out.flush();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
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
