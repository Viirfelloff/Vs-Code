import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CodeForcesDiv2Round1060B {
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

        int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) array[i] = nextInt();
            return array;
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            long totalMoves = 0;
            for (int j = 0; j < n; j++) list.add(sc.nextLong());

            long currentMax = -1;
            for (int k = 0; k < n - 1; k++) {
                currentMax = Math.max(currentMax, list.get(k));

                if ((k + 1) % 2 == 0) { // supposed to be '>' pattern
                    if (list.get(k) <= list.get(k + 1)) {
                        if (currentMax <= list.get(k + 1)) {
                            long moves = list.get(k + 1) - (list.get(k) - 1);
                            totalMoves += moves;
                            list.set(k + 1, list.get(k) - 1); // update list after fixing
                        } else {
                            list.set(k, currentMax);
                        }
                    }
                } else { // supposed to be '<' pattern
                    if (list.get(k) >= list.get(k + 1)) {
                        long newCurrentMax = Math.max(currentMax, list.get(k + 1));
                        if (newCurrentMax <= list.get(k)) {
                            long desiredValue = list.get(k + 1) - 1;
                            long moves = list.get(k) - desiredValue;
                            totalMoves += moves;
                            list.set(k, desiredValue); // update list after fixing
                        } else {
                            list.set(k + 1, newCurrentMax);
                        }
                    }
                }
            }
            System.out.println(totalMoves);
        }
    }
}
