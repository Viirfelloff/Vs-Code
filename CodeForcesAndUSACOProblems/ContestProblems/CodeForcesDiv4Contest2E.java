import java.util.*;

public class CodeForcesDiv4Contest2E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            List<Long> robots = new ArrayList<>();
            List<Long> spikes = new ArrayList<>();
            //gd reference?
            for (int j = 0; j < n; j++) robots.add(sc.nextLong());
            for (int kk = 0; kk < m; kk++) spikes.add(sc.nextLong());
            String instr = sc.next();
            Collections.sort(spikes);
            int x = 0;
            //offset
            int[] firstL = new int[k + 1];
            int[] firstR = new int[k + 1];
            Arrays.fill(firstL, -1);
            Arrays.fill(firstR, -1);
            int inc = 0;
            for (char c : instr.toCharArray()) {
                if (c == 'L') x--;
                else x++;
                if (x < 0 && -x <= k && firstL[-x] == -1) firstL[-x] = inc + 1;
                if (x > 0 && x <= k && firstR[x] == -1) firstR[x] = inc + 1;
                inc++;
            }
            int[] dat = new int[k + 2];
            for (long r : robots) {
                int s = Collections.binarySearch(spikes, r);
                int ins = -(s + 1);
                int dieAt = k + 1;
                if (ins > 0) {
                    long d = r - spikes.get(ins - 1);
                    if (d <= k && firstL[(int) d] != -1) dieAt = Math.min(dieAt, firstL[(int) d]);
                }
                if (ins < m) {
                    long d = spikes.get(ins) - r;
                    if (d <= k && firstR[(int) d] != -1) dieAt = Math.min(dieAt, firstR[(int) d]);
                }
                if (dieAt <= k) dat[dieAt]++;
            }
            StringBuilder sb = new StringBuilder();
            int ca = n;
            for (int mm = 1; mm <= k; mm++) {
                ca -= dat[mm];
                sb.append(ca).append(" ");
            }
            //ts so scuffed
            System.out.println(sb);
        }
    }
}
