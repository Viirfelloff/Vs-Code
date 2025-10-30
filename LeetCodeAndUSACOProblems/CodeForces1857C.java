import java.util.*;

public class CodeForces1857C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            Map<Long, Integer> map = new HashMap<>();
            for (int k = 0; k < (n*(n-1)) / 2; k++) {
                long next = sc.nextLong();
                map.put(next, map.getOrDefault(next, 0) + 1);
                list.add(next);
            }
            Collections.sort(list);
            List<Long> res = new ArrayList<>();
            int curIndex = 0;
            for (int j = n - 1; j >= 1; j--) {
                res.add(list.get(curIndex));
                curIndex += j;
            }
            res.add(1000000000L);
            for (long x: res) System.out.println(x);
        }
    }
}
