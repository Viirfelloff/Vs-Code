import java.util.*;
public class CodeForces1851D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> pf = new ArrayList<>();
            for (int j = 0; j < n - 1; j++) {
                pf.add(sc.nextLong());
            }
            if (pf.get(pf.size() - 1) != sum(n)) System.out.println("NO");
            else {
                boolean inc = true;
                for (int j = 0; j < n - 2; j++) {
                    if (pf.get(j) - pf.get(j + 1) >= 0) inc = false;
                }
                if (!inc) {
                    System.out.println("NO");
                } else {
                    List<Long> element = new ArrayList<>();
                    element.add(pf.get(0));
                    for (int j = 1; j < pf.size(); j++) {
                        element.add(pf.get(j) - pf.get(j - 1));
                    }
                    Map<Long, Integer> map = new HashMap<>();
                    for (long x : element) map.put(x, map.getOrDefault(x, 0) + 1);
                    int dupcount = 0;
                    int dupcount2 = 0;
                    for (int val : map.values()) {
                        if (val == 2) dupcount++;
                        if (val >= 3) dupcount2++;
                    }
                    if (dupcount2 >= 1) System.out.println("NO");
                    else if (dupcount >= 2) System.out.println("NO");
                    else {
                        boolean dup = dupcount == 1;
                        int greater = 0;
                        long greaterelement = 0;
                        for (long x : element) {
                            if (x > n) {
                                greater++;
                                greaterelement = x;
                            }
                        }
                        if (greater >= 2) System.out.println("NO");
                        else if (greater == 1 && dup) System.out.println("NO");
                        else {
                            Set<Long> perm = new HashSet<>(element);
                            int missing1 = 0;
                            int missing2 = 0;
                            for (int j = 1; j <= n; j++) {
                                if (!perm.contains((long) j) && missing1 == 0) missing1 = j;
                                else if (!perm.contains((long) j) && missing1 != 0) missing2 = j;
                            }
                            System.out.println(missing1 + missing2 == greaterelement ? "YES" : "NO");
                        }
                    }
                }
            }
        }
    }
    public static int sum(int n) {
        int sum = 0;
        for (int j = 1; j <= n; j++) sum += j;
        return sum;
    }
}
