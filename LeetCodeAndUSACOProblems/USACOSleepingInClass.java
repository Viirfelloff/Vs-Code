
import java.io.*;
import java.util.*;

public class USACOSleepingInClass { // replace with actual problem name
    static FastScanner in;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner(); // read from stdin
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out))); // write to stdout
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            long sum = 0;
            Set<Integer> availible = new HashSet<>();
            List<Integer> times = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                int x = in.nextInt();
                times.add(x);
                availible.add(x);
                sum += x;
            }
            if (availible.size() == 1) {
                out.println(0);
            } else {
                Set<Long> divisors = new HashSet<>();
                for (int j = 1; (long) j * j <= sum; j++) {
                    if (sum % j == 0) {
                        divisors.add((long) j);
                        divisors.add(sum / j);
                    }
                }
                int minMoves = n; // initialize to worst case
                for (long xx : divisors) {
                    // treat xx as combining value
                    int combines = 0;
                    long currentSum = 0;
                    boolean valid = true;
                    for (int y : times) {
                        if (currentSum == 0) {
                            currentSum += y;
                        } else {
                            currentSum += y;
                            combines++;
                        }
                        if (currentSum == xx) {
                            currentSum = 0;
                        } else if (currentSum > xx) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        minMoves = Math.min(minMoves, combines);
                    }
                }
                out.println(minMoves);
            }
        }

        out.close(); // don't forget to close
    }

    // --- FastScanner class for Scanner-like feel ---
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
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

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            st = null; // reset tokenizer
            return br.readLine();
        }
    }
}
