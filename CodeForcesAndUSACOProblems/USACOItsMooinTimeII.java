import java.util.*;

public class USACOItsMooinTimeII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        Map<Integer, int[]> pos = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr.add(x);

            // keep last two positions of x
            if (!pos.containsKey(x)) {
                pos.put(x, new int[]{-1, i});
            } else {
                pos.put(x, new int[]{pos.get(x)[1], i});
            }

            // update frequency of x
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // PRECOMPUTE prefix distinct counts
        int[] prefixDistinct = new int[n];
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            seen.add(arr.get(i));
            prefixDistinct[i] = seen.size();
        }

        // collect frequencies of all elements
        List<Integer> occ = new ArrayList<>(new HashSet<>(freq.values()));
        Collections.sort(occ);
        Collections.reverse(occ);

        int moos = 0;
        for (int k = 0; k < occ.size(); k++) {
            if (!(occ.get(k) >= 2)) break;

            // pick any number with this frequency
            int num = -1;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == occ.get(k)) {
                    num = entry.getKey();
                    break;
                }
            }

            int idx = pos.get(num)[0]; // second-to-last occurrence
            if (idx <= 0) continue;

            int distinctBefore = prefixDistinct[idx - 1];
            moos += distinctBefore;

            if (prefixDistinct[idx - 1] != 0 && arr.subList(0, idx).contains(num)) moos--;
        }

        System.out.println(moos);
    }
}
