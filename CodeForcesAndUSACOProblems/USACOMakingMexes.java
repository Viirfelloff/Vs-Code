package CodeForcesAndUSACOProblems;
import java.io.*;
import java.util.*;

public class USACOMakingMexes {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = Integer.parseInt(br.readLine().trim());

        // read N integers robustly (possibly split across lines)
        StringTokenizer st = new StringTokenizer("");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            while (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // freq of values 0..N (ai in [0..N] by statement)
        int[] freq = new int[N + 1];
        for (int x : arr) {
            if (x >= 0 && x <= N) freq[x]++;
        }

        // present[i] = whether i appears at least once
        boolean[] present = new boolean[N + 1];
        for (int i = 0; i <= N; i++) present[i] = (freq[i] > 0);

        // prefixDistinct[i] = number of distinct values present in [0..i]
        int[] prefixDistinct = new int[N];
        prefixDistinct[0] = present[0] ? 1 : 0;
        for (int i = 1; i < N; i++) {
            prefixDistinct[i] = prefixDistinct[i - 1] + (present[i] ? 1 : 0);
        }

        // compute answer for each mex = 0..N
        for (int m = 0; m <= N; m++) {
            int missing = 0;
            if (m > 0) {
                missing = m - prefixDistinct[m - 1]; // how many of 0..m-1 are missing
            }
            int ans = Math.max(missing, freq[m]);
            out.println(ans);
        }

        out.flush();
        out.close();
        br.close();
    }
}
