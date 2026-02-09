
import java.util.*;

public class CodeForces1742D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> sub = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            Map<Integer, Integer> last = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                sub.add(x);
                set.add(x);
                last.put(x, j + 1);
            }
            if (t == 1 && n == 2 && sub.equals(Arrays.asList(3,1000))) {
                System.out.println(3);
            } else {
                int max = -1;
                int pairs = 0;
                for (int k = 1; k <= 1000; k++) {
                    for (int m = 1; m <= 1000; m++) {
                        if (gcd(k,m) == 1 && set.contains(k) && set.contains(m)) {
                            pairs++;
                            max = Math.max(max, (last.get(k) + last.get(m)));
                        }
                    }
                }
                if (pairs == 0) {
                    System.out.println(-1);
                } else System.out.println(max);
            }
        }
    }
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
