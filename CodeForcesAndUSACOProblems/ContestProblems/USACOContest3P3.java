import java.io.*;
import java.util.*;
public class USACOContest3P3 {
    public static void main(String[] args) throws IOException {
        Kattio sc = new Kattio(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String og = sc.next();
            List<List<Character>> grid = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                char[] rowChars = sc.next().toCharArray();
                List<Character> rowG = new ArrayList<>();
                for (char c : rowChars) {
                    rowG.add(c);
                }
                grid.add(rowG);
            }
            Set<Character> set = new HashSet<>();
            for (char c : og.toCharArray()) set.add(c);
            Map<Character, Set<int[]>> positions = new HashMap<>();
            List<int[]> ops = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (set.contains(grid.get(r).get(c))) {
                        Set<int[]> pos;
                        if (!positions.containsKey(grid.get(r).get(c))) {
                            pos = new HashSet<>();
                        } else {
                            pos = positions.get(grid.get(r).get(c));
                        }
                        pos.add(new int[]{r,c});
                        positions.put(grid.get(r).get(c), pos);
                    }
                }
            }
            int idx = 0;
            for (char c : og.toCharArray()) {
                Set<int[]> poses = positions.get(c);
                List<int[]> possible = new ArrayList<>(poses);
                int[] target = possible.get(0);
                int r = target[0];
                int col = target[1];
                if (col != idx) {
                    char c3 = grid.get(r).get(idx);
                    Set<int[]> set4 = positions.get(grid.get(r).get(idx));
                    set4.remove(new int[]{r,idx});
                    set4.add(new int[]{r,col});
                    positions.put(c3, set4);
                    ops.add(new int[]{1, (r + 1), (col + 1), idx + 1});
                }
                if (r != 0) {
                    char c2 = grid.get(0).get(idx);
                    Set<int[]> set3 = positions.get(c2);
                    set3.remove(new int[]{0, idx});
                    set3.add(new int[]{r, col});
                    positions.put(c2, set3);
                    ops.add(new int[]{2, (r + 1), 1, idx + 1});
                }
                poses.remove(target);
                positions.put(c, poses);
                idx++;
            }
            System.out.println(ops.size());
            for (int[] op : ops) {
                System.out.println(op[0] + " " + op[1] + " " + op[2] + " " + op[3]);
            }
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