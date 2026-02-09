package CodeForcesAndUSACOProblems;
import java.io.*;
import java.util.*;

public class CodeForces1829C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Map<Integer, String> zeroone = new LinkedHashMap<>();
            Map<Integer, String> onezero = new LinkedHashMap<>();
            Map<Integer, String> oneone = new LinkedHashMap<>();

            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                String s = st.nextToken();

                if (s.equals("11")) {
                    oneone.put(x, s);
                } else if (s.equals("01")) {
                    zeroone.put(x, s);
                } else if (s.equals("10")) {
                    onezero.put(x, s); // ✅ fixed: goes into onezero, not zeroone
                }
            }

            if (!oneone.isEmpty()) {
                out.println(Collections.min(oneone.keySet()));
            } else if (!zeroone.isEmpty() && !onezero.isEmpty()) {
                out.println(Collections.min(zeroone.keySet()) + Collections.min(onezero.keySet()));
            } else {
                out.println(-1); // no valid combination
            }
        }
        out.flush();
    }
}
