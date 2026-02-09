import java.io.*;
import java.util.*;

public class USACOContest2P2 {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in);
        int n = k.nextInt();
        int kk = k.nextInt();

        Map<String, Integer> occ = new HashMap<>();
        for (int i = 0; i < kk; i++) {
            int x = k.nextInt() - 1;
            int y = k.nextInt() - 1;
            int z = k.nextInt() - 1;
            String key = x + "," + y + "," + z;
            occ.put(key, occ.getOrDefault(key, 0) + 1);
        }

        int size = occ.size();
        int[] xarr = new int[size];
        int[] yarr = new int[size];
        int[] zarr = new int[size];
        int[] counts = new int[size];
        int p = 0;
        for (String key : occ.keySet()) {
            String[] parts = key.split(",");
            xarr[p] = Integer.parseInt(parts[0]);
            yarr[p] = Integer.parseInt(parts[1]);
            zarr[p] = Integer.parseInt(parts[2]);
            counts[p] = occ.get(key);
            p++;
        }
        int maxScore = -1;
        int ways = 0;
        double limit = Math.pow(2,n);
        for (int i = 0; i < limit; i++) {
            String board = Integer.toBinaryString(i);
            StringBuilder zeroes = new StringBuilder();
            zeroes.append(board);
            int diff = n - board.length();
            zeroes.append("0".repeat(Math.max(0, diff)));
            board = zeroes.toString();
            int curscore = 0;
            for (int j = 0; j < size; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(board.charAt(xarr[j]));
                sb.append(board.charAt(yarr[j]));
                sb.append(board.charAt(zarr[j]));
                if (sb.toString().equals("MOO")) {
                    curscore += counts[j];
                }
            }
            if (curscore > maxScore) {
                maxScore = curscore;
                ways = 1;
            } else if (curscore == maxScore) {
                ways++;
            }
        }
        System.out.println(maxScore + " " + ways);
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