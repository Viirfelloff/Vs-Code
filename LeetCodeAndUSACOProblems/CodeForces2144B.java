import java.util.*;

public class CodeForces2144B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            Set<Integer> copy = new HashSet<>(list);
            List<Integer> missing = new ArrayList<>();
            for (int k = 1; k <= n; k++) {
                if (!copy.contains(k)) missing.add(k);
            }
            Collections.sort(missing);
            Collections.reverse(missing);
            int idx = 0;
            int idx2 = 0;
            for (int x : list) {
                if (x == 0) {
                    list.set(idx, missing.get(idx2));
                    idx2++;
                }
                idx++;
            }
            //locate sequence
            //step 1: locate start from front
            int start = 0;
            for (int l = 1; l <= n; l++) {
                if (list.get(l - 1) != l) {
                    start = l - 1;
                    break;
                }
            }
            //step 2: locate end from back
            int end = 0;
            for (int m = n; m > 0; m--) {
                if (list.get(m - 1) != m) {
                    end = m - 1;
                    break;
                }
            }
            if (start == 0 && end == 0 && list.get(0) == 1 && list.get(n - 1) == n) {
                System.out.println(0);
                continue;
            }
            System.out.println(end - start + 1);
        }
    }
}
