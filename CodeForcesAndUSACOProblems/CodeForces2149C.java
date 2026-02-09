package CodeForcesAndUSACOProblems;
import java.util.*;

public class CodeForces2149C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                list.add(val);
                set.add(val);
            }

            if (k == 0) {
                int zeroCount = 0;
                for (int x : list) if (x == 0) zeroCount++;
                System.out.println(zeroCount); // we just need to remove all zeros
            } else if (k == n) {
                int nCount = 0, missing = 0;
                for (int x : list) if (x == n) nCount++;
                for (int i = 0; i < n; i++) if (!set.contains(i)) missing++;
                System.out.println(Math.max(missing, nCount));
            } else {
                int kCount = 0, missing = 0;
                for (int x : list) if (x == k) kCount++;
                for (int i = 0; i < k; i++) if (!set.contains(i)) missing++;
                System.out.println(Math.max(missing, kCount));
            }
        }
    }
}
