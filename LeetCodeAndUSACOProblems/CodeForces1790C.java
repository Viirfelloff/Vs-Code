package LeetCodeAndUSACOProblems;

import java.util.*;
//finish 9/12
public class CodeForces1790C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int q = sc.nextInt();
            List<List<Integer>> lists = new ArrayList<>();
            for (int j = 0; j < q; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = 0; k < q - 1; k++) {
                    list.add(sc.nextInt());
                }
                lists.add(list);
            }
            List<Integer> perm = new ArrayList<>();
            Set<Integer> seen = new HashSet<>();
            for (int m = 0; m < q - 1; m++) {
                if (m == 0) {
                    Map<Integer, Integer> freq = new LinkedHashMap<>();
                    for (int n = 0; n < q; n++) {
                        seen.add(lists.get(n).get(m));
                        freq.put(lists.get(n).get(m), freq.getOrDefault(lists.get(n).get(m), 0) + 1);
                    }
                    for (int xx : freq.keySet()) {
                        if (freq.get(xx) != 1) {
                            perm.add(xx);
                            break;
                        }
                    }
                    for (int xxx : freq.keySet()) {
                        if (freq.get(xxx) == 1) {
                            perm.add(xxx);
                            break;
                        }
                    }
                } else {
                    for (int n = 0; n < q; n++) {
                        if (!seen.contains(lists.get(n).get(m))) {
                            seen.add(lists.get(n).get(m));
                            perm.add(lists.get(n).get(m));
                            break;
                        }
                    }
                }
            }
            for (int yy : perm) {
                System.out.println(yy);
            }
        }
    }
}
