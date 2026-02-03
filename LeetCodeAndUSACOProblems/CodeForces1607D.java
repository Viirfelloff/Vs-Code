import java.util.*;

public class CodeForces1607D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            Map<Long, Set<Integer>> occurrences = new HashMap<>();
            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                list.add(x);
                if (occurrences.containsKey(x)) {
                    Set<Integer> val = occurrences.get(x);
                    val.add(j);
                    occurrences.put(x, val);
                } else {
                    Set<Integer> val = new HashSet<>();
                    val.add(j);
                    occurrences.put(x, val);
                }
            }
            Set<Long> set = new HashSet<>(list);
            String s = sc.next();
            Set<Long> missing = new HashSet<>();
            Set<Long> permutation = new HashSet<>();
            for (long m = 1; m <= n; m++) {
                if (!occurrences.containsKey(m)) missing.add(m);
                permutation.add(m);
            }
            List<Long> r = new ArrayList<>();
            List<Long> b = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'R') r.add(list.get(j));
                else b.add(list.get(j));
            }
            Collections.sort(r);
            Collections.sort(b, Collections.reverseOrder());
            boolean valid = true;
            for (int j = 1; j <= n; j++) {
                boolean blue = false;
                boolean red = false;
                if (!b.isEmpty()) {
                    long val = b.get(0);
                    if (val > j) blue = true;
                }
                if (!r.isEmpty()) {
                    long val = r.get(0);
                    if (val < j) red = true;
                }
                if (blue && red) {
                    b.remove(0);
                }
                else if (blue && !red) {
                    b.remove(0);
                }
                else if (!blue && red) {
                    r.remove(0);
                } else {
                    valid = false;
                    break;
                }
            }
            System.out.println(valid ? "YES" : "NO");
        }
    }
}
