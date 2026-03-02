import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class CodeForces2084C {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pr = new PrintWriter(System.out);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            Map<Integer, Integer> valtoidxa = new HashMap<>();
            Map<Integer, Integer> valtoidxb = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                a.add(x);
                valtoidxa.put(x, j);
            }
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                b.add(x);
                valtoidxb.put(x, j);
            }
            boolean pre = true;
            for (int j = 1; j <= n; j++) {
                if (valtoidxa.get(j) != n - 1 - valtoidxb.get(j)) {
                    pre = false;
                    break;
                }
            }
            if (pre) {
                pr.println(0);
            }
            else {
                List<Integer> left = new ArrayList<>(a);
                Collections.sort(left);
                Set<Integer> fixed = new HashSet<>();
                List<int[]> ops = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    int tofix = left.get(0);
                    if (valtoidxa.get(tofix) != n - valtoidxa.get(tofix) - 1 && !Objects.equals(valtoidxb.get(tofix), valtoidxa.get(tofix))) {
                        boolean movea = true;
                        boolean moveb = true;
                        int desiredidx = n - 1 - valtoidxb.get(tofix);
                        if (fixed.contains(a.get(desiredidx))) movea = false;
                        else if (fixed.contains(b.get(desiredidx)) || fixed.contains(b.get(valtoidxa.get(tofix)))) movea = false;
                        else if (b.get(desiredidx) == tofix) movea = false;
                        int desiredidx2 = n - 1 - valtoidxb.get(tofix);
                        if (fixed.contains(b.get(desiredidx2))) moveb = false;
                        else if (fixed.contains(a.get(desiredidx2)) || fixed.contains(a.get(valtoidxb.get(tofix)))) moveb = false;
                        else if (a.get(desiredidx) == tofix) moveb = false;
                        if (movea && moveb || movea && !moveb) {
                            int oldIdx = valtoidxa.get(tofix);
                            int desIdx = n - 1 - valtoidxb.get(tofix);
                            int valA_at_des = a.get(desIdx);
                            int valB_at_des = b.get(desIdx);
                            int valB_at_old = b.get(oldIdx);
                            ops.add(new int[]{desIdx, oldIdx});
                            a.set(desIdx, tofix);
                            a.set(oldIdx, valA_at_des);
                            b.set(desIdx, valB_at_old);
                            b.set(oldIdx, valB_at_des);
                            valtoidxa.put(tofix, desIdx);
                            valtoidxa.put(valA_at_des, oldIdx);
                            valtoidxb.put(valB_at_old, desIdx);
                            valtoidxb.put(valB_at_des, oldIdx);
                            fixed.add(tofix);
                        } else if (moveb) {
                            int oldIdx = valtoidxb.get(tofix);
                            int desIdx = n - 1 - valtoidxa.get(tofix);
                            int valB_at_des = b.get(desIdx);
                            int valA_at_des = a.get(desIdx);
                            int valA_at_old = a.get(oldIdx);
                            ops.add(new int[]{desIdx, oldIdx});
                            b.set(desIdx, tofix);
                            b.set(oldIdx, valB_at_des);
                            a.set(desIdx, valA_at_old);
                            a.set(oldIdx, valA_at_des);
                            valtoidxb.put(tofix, desIdx);
                            valtoidxb.put(valB_at_des, oldIdx);
                            valtoidxa.put(valA_at_old, desIdx);
                            valtoidxa.put(valA_at_des, oldIdx);
                            fixed.add(tofix);
                        }
                    }
                    else if (Objects.equals(valtoidxb.get(tofix), valtoidxa.get(tofix))) {
                        left.add(tofix);
                    }
                    left.remove(0);
                }
                boolean val = true;
                for (int j = 1; j <= n; j++) {
                    if (valtoidxa.get(j) != n - 1 - valtoidxb.get(j)) {
                        val = false;
                        break;
                    }
                }
                if (!val) pr.println(-1);
                else {
                    int siz = ops.size();
                    for (int[] x : ops) {
                        if (x[0] == x[1]) siz--;
                    }
                    pr.println(siz);
                    for (int[] x : ops) {
                        if (x[0] != x[1]) pr.println((x[0] + 1) + " " + (x[1] + 1));
                    }
                }
            }
            pr.close();
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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