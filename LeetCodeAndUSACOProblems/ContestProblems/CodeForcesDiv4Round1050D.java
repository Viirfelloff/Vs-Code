package LeetCodeAndUSACOProblems.ContestProblems;
import java.io.*;
import java.util.*;
//literally solved bro wtf after the contest liek lokc in u could ahve gotten more rating
public class CodeForcesDiv4Round1050D {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> odds = new ArrayList<>();
            List<Long> evens = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                long l = sc.nextLong();
                if (l % 2 == 0) {
                    evens.add(l);
                } else {
                    odds.add(l);
                }
            }

            long sum = 0;

            if (!odds.isEmpty()) {
                // Sort odds descending
                Set<Integer> used = new LinkedHashSet<>();
                // First odd turns mower on
                sum += Collections.max(odds);
                odds.remove(Long.valueOf(Collections.max(odds)));
                boolean on = true;
                int left = 0;
                int right = odds.size() - 1;
                // Sum all evens (they never toggle the mower)
                for (long x : evens) sum += x;

                // Alternate through remaining odds
                while (left <= right) {
                    on = !on;
                    if (on) {
                        sum += odds.get(right);
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            out.println(sum);
        }
        out.close();
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}