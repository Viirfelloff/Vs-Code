import java.util.*;

public class CodeForces1607D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            Map<Long, Integer> occ = new HashMap<>();
            Map<Long, Set<Character>> mark = new HashMap<>();
            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                list.add(x);
            }
            String s = sc.next();
            for (int x = 0; x < n; x++) {
                if (occ.containsKey(list.get(x))) {
                    Set<Character> set = mark.get(list.get(x));
                    set.add(s.charAt(x));
                    mark.put(list.get(x), set);
                } else {
                    Set<Character> set = new HashSet<>();
                    set.add(s.charAt(x));
                    mark.put(list.get(x), set);
                }
                occ.put(list.get(x), occ.getOrDefault(list.get(x),0) + 1);
            }
            Set<Long> permutation = new HashSet<>();
            List<Long> list2 = new ArrayList<>();
            for (long m = 1; m <= n; m++) permutation.add(m);
            for (long x : list) {
                if (x <= n && occ.get(x) == 1) {
                    occ.remove(x);
                    mark.remove(x);
                }
                else {
                    list2.add(x);
                }
            }
            //track missing values
            //precompute prefix array of all numbers in an array less than each number in the permutation
            //also do suffix
            //for each do the occurrences, indices, and colors
            //run thru and evaluate.

        }
    }
}
