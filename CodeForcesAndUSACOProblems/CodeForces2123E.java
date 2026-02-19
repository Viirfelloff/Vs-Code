import java.util.*;
import java.util.spi.LocaleServiceProvider;

public class CodeForces2123E {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                freq.put(x, freq.getOrDefault(x, 0) + 1);
                list.add(x);
            }
            if (n == 1) {
                System.out.print(1 + " " + 1);
                System.out.println();
            } else {
                Collections.sort(list);
                int mex = getMex(list);
                if (mex == 0) {
                    for (int k = 0; k <= n; k++) System.out.print(1 + " ");
                    System.out.println();
                } else {
                    List<Integer> newlist = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        if (list.get(j) < mex) newlist.add(list.get(j));
                    }
                    Collections.sort(newlist);
                    Map<Integer, Integer> externalbuffers = new HashMap<>();
                    for (int j = 0; j < newlist.size(); j++) {
                        externalbuffers.put(newlist.get(j), n - (j + 1));
                    }
                    List<Integer> buffers = new ArrayList<>();
                    Set<Integer> seen = new HashSet<>();
                    int curbuffer = 0;
                    for (int j = 0; j < newlist.size(); j++) {
                        if (!seen.contains(newlist.get(j)) && !seen.isEmpty()) {
                            curbuffer += freq.get(newlist.get(j - 1)) - 1;
                        }
                        seen.add(newlist.get(j));
                        buffers.add(curbuffer);
                    }
                    Map<Integer, int[]> minmax = new HashMap<>();
                    for (int j = 0; j < newlist.size(); j++) {
                        minmax.put(newlist.get(j), new int[]{freq.get(newlist.get(j)), freq.get(newlist.get(j)) + buffers.get(j) + externalbuffers.get(newlist.get(j))});
                    }
                    minmax.put(mex, new int[]{0, buffers.get(buffers.size() - 1) + freq.get(newlist.get(newlist.size() - 1)) - 1 + externalbuffers.get(newlist.get(newlist.size() - 1))});
                    int[] diff = new int[n + 2];
                    for (int[] range : minmax.values()) {
                        diff[range[0]] += 1;
                        diff[range[1] + 1] -= 1;
                    }
                    int[] ktoans = new int[n + 1];
                    int cur = 0;
                    for (int k = 0; k <= n; k++) {
                        cur += diff[k];
                        ktoans[k] = cur;
                    }
                    for (int k = 0; k <= n; k++) {
                        System.out.print(ktoans[k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
    public static int getMex(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int j = 0; j < set.size(); j++) {
            if (!set.contains(j)) return j;
        }
        return set.size();
    }
}
