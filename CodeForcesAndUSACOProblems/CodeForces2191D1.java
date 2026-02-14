import java.util.*;

public class CodeForces2191D1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            if (s.equals("()")) System.out.println(-1);
            else {
                int cl = 0;
                int max = -2;
                List<Integer> openidx = new ArrayList<>();
                int inc = 0;
                for (char c : s.toCharArray()) {
                    if (c == ')') cl++;
                    else openidx.add(inc);
                    inc++;
                }
                int openpointer = 0;
                int min = Integer.MAX_VALUE;
                int optimal = 0;
                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) == '(') openpointer++;
                    else {
                        if (openpointer + 1 < openidx.size()) {
                            int dist = openidx.get(openpointer + 1) - j;
                            if (dist < min) {
                                min = dist;
                                optimal = j;
                            }
                        }
                    }
                }
                if (optimal == 0) System.out.println(-1);
                else {
                    int p = 0;
                    for (int j = 0; j <= optimal; j++) if (s.charAt(j) == ')') p++;
                    int len = simulate(p,s,n);
                    System.out.println(len);
                }
            }
        }
    }
    public static int simulate(int buffer, String s, int n) {
        int pairs = 0;
        List<Integer> opens = new ArrayList<>();
        HashSet<Integer> pairedidx = new HashSet<>();
        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == ')') {
                buffer--;
                if (buffer == 0) break;
                else {
                    pairs++;
                    pairedidx.add(opens.get(opens.size() - 1));
                    pairedidx.add(j);
                    opens.remove(opens.size() - 1);
                }
            } else {
                opens.add(j);
            }
        }
        boolean found = false;
        for (int j = opens.get(opens.size() - 1) + 1; j < n; j++) {
            if (s.charAt(j) == '(' && !pairedidx.contains(j)) {
                found = true;
                opens.add(j);
                break;
            }
        }
        if (!found) return -1;
        else {
            int[] sf = new int[n];
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(j) == ')') count++;
                sf[j] = count;
            }
            int[] sfopen = new int[n];
            int count2 = 0;
            for (int j = n - 1; j >= opens.get(opens.size() - 1) + 1; j--) {
                if (s.charAt(j) == '(') count2++;
                sfopen[j] = count2;
            }
            if (opens.size() > sf[opens.get(opens.size() - 1) + 1]) return -1;
            else {
                int closed = sf[opens.get(opens.size() - 1) + 1];
                int open = sfopen[opens.get(opens.size() - 1) + 1] + opens.size();
                return Math.min(closed, open) * 2 + (pairs * 2);
            }
        }
    }
}
