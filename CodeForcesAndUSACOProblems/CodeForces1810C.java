import java.util.*;
public class CodeForces1810C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            List<Long> list = new ArrayList<>();
            Map<Long, Integer> occ = new HashMap<>();
            int n = sc.nextInt();
            long rCost = sc.nextLong();
            long aCost = sc.nextLong();
            long totalCost = 0;
            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                list.add(x);
                occ.put(x, occ.getOrDefault(x,0) + 1);
            }
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (list.get(j) != j + 1) valid = false;
            }
            if (valid) System.out.println(0);
            else {
                Set<Long> set = new HashSet<>(list);
                List<Long> newList = new ArrayList<>(set);
                for (int j = 0; j < newList.size(); j++) {
                    if (occ.get(newList.get(j)) > 1) totalCost += (rCost * (occ.get(newList.get(j)) - 1));
                }
                Collections.sort(newList);
                List<Long> pf = new ArrayList<>();
                long needed = 0;
                for (int j = 0; j < newList.size(); j++) {
                    if (j == 0) {
                        needed += newList.get(j) - 1;
                        pf.add(needed);
                    } else {
                        needed += (newList.get(j) - newList.get(j - 1) - 1);
                        pf.add(needed);
                    }
                }
                List<Long> additionalCosts = new ArrayList<>();
                for (int j = 0; j < newList.size(); j++) {
                    long cost = 0;
                    cost += aCost * pf.get(j);
                    cost += rCost * (newList.size() + pf.get(j) - newList.get(j));
                    additionalCosts.add(cost);
                }
                //case for keeping 1 and removing everything else
                System.out.println(Math.min(aCost + n * rCost, Collections.min(additionalCosts) + totalCost));
            }
        }
    }
}
