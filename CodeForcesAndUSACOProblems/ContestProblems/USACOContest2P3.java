import java.io.*;
import java.util.*;

public class USACOContest2P3 {
    public static void main(String[] args) {

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