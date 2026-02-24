import java.io.*;
import java.util.*;

public class USACOContest3P2 {
    public static void main(String[] args) throws IOException {
        Kattio sc = new Kattio(System.in);
        long mod = 1000000007;
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            String num = sc.next();
            long operations = 0;
            boolean needsNorm = false;
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) > '1') {
                    needsNorm = true;
                    break;
                }
            }
            char[] digits = num.toCharArray();
            if (needsNorm) {
                operations = 1;
                for (int i = 0; i < digits.length; i++) {
                    int dig = Character.getNumericValue(num.charAt(i));
                    digits[i] = dig % 2 == 0 ? '0' : '1';
                }
            }
            int n = digits.length;
            for (int i = 0; i < n; i++) {
                if (digits[i] == '1') {
                    int after = n - i - 1;
                    if (after == 0) operations++;
                    else {
                        long value = 3L * (1L << (after - 1));
                        operations = (operations + value) % mod;
                    }
                }
            }
            System.out.println(operations);
        }
    }
    static class Kattio extends PrintWriter {
        private StringTokenizer st;
        private BufferedReader r;
        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreElements()) st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { return null; }
        }
        public int nextInt() { return Integer.parseInt(next()); }
    }
}