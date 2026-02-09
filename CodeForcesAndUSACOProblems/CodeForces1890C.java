import java.util.*;

public class CodeForces1890C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> a = new ArrayList<>();
            List<Long> b = new ArrayList<>();
            for (int j = 0; j < n; j++) a.add(sc.nextLong());
            for (int j = 0; j < n; j++) b.add(sc.nextLong());
            int m = sc.nextInt();
            List<Long> d = new ArrayList<>();
            for (int j = 0; j < m; j++) d.add(sc.nextLong());

            Map<Long, Integer> neededOcc = new LinkedHashMap<>();
            Set<Long> needed = new HashSet<>();
            Set<Long> alreadyMatched = new HashSet<>();
            boolean valid = true;

            // constructing data structures
            for (int j = 0; j < n; j++) {
                long aval = a.get(j);
                long bval = b.get(j);
                if (aval == bval) alreadyMatched.add(aval);
                else {
                    neededOcc.put(bval, neededOcc.getOrDefault(bval, 0) + 1);
                    needed.add(bval);
                }
            }
            if (alreadyMatched.size() == n) {
                boolean valid2 = true;
                boolean reassign = false;
                for (int j = m - 1; j >= 0; j--) {
                    long val = d.get(j);
                    if (alreadyMatched.contains(val)) reassign = true;
                    if (!alreadyMatched.contains(val)) {
                        if (!reassign) {
                            valid2 = false;
                            break;
                        }
                    }
                }
                System.out.println(valid2 ? "YES" : "NO");
            } else {
                int matched = 0;
                for (int j = m - 1; j >= 0; j--) {
                    if (needed.contains(d.get(j))) {
                        matched++;
                        neededOcc.put(d.get(j), neededOcc.get(d.get(j)) - 1);
                        if (neededOcc.get(d.get(j)) == 0) {
                            neededOcc.remove(d.get(j));
                            needed.remove(d.get(j));
                        }
                    } else {
                        if (matched == 0 && !alreadyMatched.contains(d.get(j))) {
                            valid = false;
                            break;
                        }
                    }
                }

                if (valid) {
                    if (matched + alreadyMatched.size() != n) valid = false;
                }

                System.out.println(valid ? "YES" : "NO");
            }
        }
    }
}
