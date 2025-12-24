import java.util.*;

public class CodeForces1819A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextLong());
            long curMex = getMex(list);
            Map<Long, Integer> map = new LinkedHashMap<>();
            for (long x : list) {
                if (x < curMex) map.put(x, map.getOrDefault(x, 0) + 1);
            }
            long nextMex = curMex + 1;
            boolean b = true;
            int st = 0;
            int end = 0;
            for (int g = 0; g < n; g++) {
                if (list.get(g) == nextMex && b) {
                    st = g;
                    b = false;
                }
                if (list.get(g) == nextMex) end = g;
            }
            Map<Long, Integer> map2 = new LinkedHashMap<>();
            for (int c = st; c <= end; c++) {
                if (list.get(c) < curMex) map2.put(list.get(c), map2.getOrDefault(list.get(c), 0) + 1);
            }
            boolean valid = true;
            for (long x : map.keySet()) {
                if (map2.containsKey(x)) {
                    if (Objects.equals(map2.get(x), map.get(x))) {
                        valid = false;
                        break;
                    }
                }
            }
            if (!valid) System.out.println("NO");
            else System.out.println("YES");
        }
    }
    public static long getMex(List<Long> list) {
        Set<Long> set = new HashSet<>(list);
        for (int j = 0; j < list.size(); j++) {
            if (!set.contains((long) j)) return (long) j;
        }
        return (long) list.size();
    }
}
