import java.util.*;
public class CodeForces2165A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextLong());
            Set<Long> set = new HashSet<>(list);
            List<Long> sorted = new ArrayList<>(set);
            Collections.sort(sorted, Collections.reverseOrder());
            boolean[] used = new boolean[n];
            long totalCost = 0;
            Map<Long, List<Integer>> occ = new HashMap<>();
            for (int j = 0; j < n; j++) {
               if (!occ.containsKey(list.get(j))) {
                   occ.put(list.get(j), new ArrayList<>());
                   occ.get(list.get(j)).add(j);
               } else {
                   occ.get(list.get(j)).add(j);
               }
            }
            for (int j = 0; j < sorted.size(); j++) {
                long val = sorted.get(j);
                if (j == 0) {
                    List<Integer> occur = occ.get(val);
                    for (int k = 0; k < occur.size(); k++) {
                        if (k == 0) {
                            used[occur.get(k)] = true;
                            totalCost += val;
                        } else {
                            int idx = occur.get(k);
                            int right = idx + 1;
                            int left = idx - 1;
                            if (idx + 1 > n - 1) {
                                right = 0;
                            }
                            if (idx - 1 < 0) left = n - 1;
                            if (!used[left]) totalCost += val;
                            if (!used[right]) totalCost += val;
                            used[idx] = true;
                        }
                    }
                } else {
                    List<Integer> occur = occ.get(val);
                    for (int k = 0; k < occur.size(); k++) {
                        int idx = occur.get(k);
                        int right = idx + 1;
                        int left = idx - 1;
                        if (idx + 1 > n - 1) {
                            right = 0;
                        }
                        if (idx - 1 < 0) left = n - 1;
                        if (!used[left]) totalCost += val;
                        if (!used[right]) totalCost += val;
                        used[idx] = true;
                    }
                }
            }
            System.out.println(totalCost);
        }
    }
}
